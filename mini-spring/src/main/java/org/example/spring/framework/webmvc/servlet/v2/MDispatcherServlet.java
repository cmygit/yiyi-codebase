package org.example.spring.framework.webmvc.servlet.v2;

import org.example.spring.framework.annotation.MController;
import org.example.spring.framework.annotation.MRequestMapping;
import org.example.spring.framework.annotation.MRequestParam;
import org.example.spring.framework.context.MApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/8/22 21:08
 */
@WebServlet(name = "mini-mvc2", urlPatterns = "/*",
        initParams = {@WebInitParam(name = "contextConfigLocation", value = "application.properties")},
        loadOnStartup = 1
)
public class MDispatcherServlet extends HttpServlet {

    private MApplicationContext context;

    private Map<String, Method> handlerMapping = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        // IOC
        this.context = new MApplicationContext(config.getInitParameter("contextConfigLocation"));

        // MVC
        // 初始化HandlerMapping
        doInitHandlerMapping();

        System.out.println("Mini Spring Framework is initialized.");
    }

    /**
     * 初始化HandlerMapping
     */
    private void doInitHandlerMapping() {
        if (this.context.getDefinitionCount() == 0) {
            return;
        }

        Set<String> beanNames = this.context.getDefinitionNames();

        for (String beanName : beanNames) {
            Class<?> clazz = this.context.getBean(beanName)
                                         .getClass();

            if (!clazz.isAnnotationPresent(MController.class)) {
                continue;
            }

            String baseUrl = "";

            if (clazz.isAnnotationPresent(MRequestMapping.class)) {
                MRequestMapping annotation = clazz.getAnnotation(MRequestMapping.class);
                baseUrl = annotation.value();
            }

            for (Method method : clazz.getMethods()) {
                if (!method.isAnnotationPresent(MRequestMapping.class)) {
                    continue;
                }

                MRequestMapping annotation = method.getAnnotation(MRequestMapping.class);

                String url = "/" + baseUrl + "/" + annotation.value();
                // 去除重复的“/”
                url = url.replaceAll("/+", "/");

                this.handlerMapping.put(url, method);
                System.out.println("Mapped: " + url + "," + method);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            resp.getWriter().write("500 Exception Detail: " + Arrays.toString(e.getStackTrace()));
        }
    }

    /**
     * 调用具体的方法
     *
     * @param req  request
     * @param resp response
     */
    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = ("/" + url).replaceAll(contextPath, "").replaceAll("/+", "/");

        if (!this.handlerMapping.containsKey(url)) {
            resp.getWriter().write("404 Not Found.");
            return;
        }
        // 请求参数
        Map<String, String[]> reqParams = req.getParameterMap();

        // 请求调用的方法
        Method method = this.handlerMapping.get(url);
        // 方法形参的注解集合（二维数组，可能有多个参数，每个参数可能有多个注解）
        Annotation[][] methodParamAnnotations = method.getParameterAnnotations();
        // 方法形参类型集合
        Class<?>[] methodParamTypes = method.getParameterTypes();
        // 存放方法实参
        Object[] methodParamValues = new Object[methodParamTypes.length];

        // 按顺序遍历(保证参数传递的顺序性)，根据方法形参的类型，对方法参数赋值，存放到paramValues中
        for (int i = 0; i < methodParamTypes.length; i++) {
            Class<?> parameterType = methodParamTypes[i];
            if (parameterType == HttpServletRequest.class) {
                methodParamValues[i] = req;
            } else if (parameterType == HttpServletResponse.class) {
                methodParamValues[i] = resp;
            } else if (parameterType == String.class) {
                for (Annotation annotation : methodParamAnnotations[i]) {
                    if (!(annotation instanceof MRequestParam)) {
                        continue;
                    }

                    String paramName = ((MRequestParam) annotation).value();

                    String value = Arrays.toString(reqParams.get(paramName))
                                         .replaceAll("[\\[\\]]", "")
                                         .replaceAll("\\s+", "");
                    // 保存请求参数值
                    methodParamValues[i] = value;
                }

            } else {
                methodParamValues[i] = null;
            }
        }

        // 调用方法
        Object instance = this.context.getBean(method.getDeclaringClass());
        method.invoke(instance, methodParamValues);
    }
}
