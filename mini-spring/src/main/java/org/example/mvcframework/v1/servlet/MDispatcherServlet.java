package org.example.mvcframework.v1.servlet;

import org.example.mvcframework.v1.annotation.MAutoWired;
import org.example.mvcframework.v1.annotation.MController;
import org.example.mvcframework.v1.annotation.MRequestMapping;
import org.example.mvcframework.v1.annotation.MService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/8/22 21:08
 */
@WebServlet(name = "mmvc", urlPatterns = "/*",
        initParams = {@WebInitParam(name = "contextConfigLocation", value = "application.properties")},
        loadOnStartup = 1
)
public class MDispatcherServlet extends HttpServlet {

    private Properties contextConfig = new Properties();

    private List<String> classNames = new ArrayList<>();

    private Map<String, Object> ioc = new HashMap<>();

    private Map<String, Method> handlerMapping = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 1、读取配置文件
        String contextConfigLocation = config.getInitParameter("contextConfigLocation");
        doLoadConfig(contextConfigLocation);

        // 2、扫描相关的类
        String scanPackage = this.contextConfig.getProperty("scanPackage");
        doScanner(scanPackage);

        // 3、实例化相关的类，并且缓存到ioc容器中
        doInstance();

        // 4、完成依赖注入
        doAutoWired();

        // 5、初始化HandlerMapping
        doInitHandlerMapping();

        System.out.println("Mini Spring Framework is initialized.");
    }

    /**
     * 读取配置文件
     *
     * @param contextConfigLocation 配置文件名
     */
    private void doLoadConfig(String contextConfigLocation) {
        // 到classPath中找到配置文件，装换为文件流
        try (InputStream inputStream = this.getClass()
                                           .getClassLoader()
                                           .getResourceAsStream(contextConfigLocation)) {
            // 加载配置文件
            this.contextConfig.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 扫描相关的类
     *
     * @param scanPackage 需要扫描的包路径
     */
    private void doScanner(String scanPackage) {
        // 把包路径的“.”替换为“/”
        String path = "/" + scanPackage.replaceAll("\\.", "/");
        URL url = this.getClass().getClassLoader().getResource("/" + path);
        // 获取class文件
        File classFile = new File(url.getFile());

        for (File file : classFile.listFiles()) {
            // 如果是文件夹，则将文件夹名字拼接到类的限定名，递归寻找class文件
            if (file.isDirectory()) {
                this.doScanner(scanPackage + "." + file.getName());
            }

            // 跳过非class文件
            if (!file.getName().endsWith(".class")) {
                continue;
            }

            // 拼接类的限定名，用于Class.forName()获取类
            String className = scanPackage + "." + file.getName().replace(".class", "");
            this.classNames.add(className);
        }
    }

    /**
     * 实例化相关的类，并且缓存到ioc容器中
     */
    private void doInstance() {
        if (this.classNames.isEmpty()) {
            return;
        }

        try {
            for (String className : this.classNames) {
                Class<?> clazz = Class.forName(className);

                // 如果类没有加相关注解，则不添加到ioc容器中
                if (!clazz.isAnnotationPresent(MController.class) && !clazz.isAnnotationPresent(MService.class)) {
                    continue;
                }

                String beanName = "";
                // 若注解中指定了beanName，则使用注解指定的beanName
                if (clazz.isAnnotationPresent(MController.class)) {
                    beanName = clazz.getAnnotation(MController.class).value();
                } else if (clazz.isAnnotationPresent(MService.class)) {
                    beanName = clazz.getAnnotation(MService.class).value();
                }

                if ("".equals(beanName)) {
                    // 默认beanName，将类名首字母转为小写
                    beanName = this.toLowerFirstCase(clazz.getSimpleName());
                }

                Object instance = clazz.newInstance();
                // 将实例对象添加到ioc容器中
                this.ioc.put(beanName, instance);

                // 如果类实现了接口，将接口的类名作为key添加到ioc容器中
                for (Class<?> anInterface : clazz.getInterfaces()) {
                    // 如果一个接口有多个类实现，重复添加时抛出异常
                    if (this.ioc.containsKey(anInterface.getName())) {
                        throw new Exception("The beanName is exists..");
                    }

                    this.ioc.put(anInterface.getName(), instance);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将字符串首字母转为小写
     *
     * @param str
     * @return
     */
    private String toLowerFirstCase(String str) {
        char[] chars = str.toCharArray();
        // 通过修改ASCII 编码表中对应的码值进行转换
        // 大小写码值相差32
        chars[0] += 32;
        return String.valueOf(chars);
    }

    /**
     * 依赖注入
     */
    private void doAutoWired() {
        if (this.ioc.isEmpty()) {
            return;
        }

        for (Map.Entry<String, Object> entry : this.ioc.entrySet()) {
            // 获取bean的所有字段
            Field[] fields = entry.getValue().getClass().getDeclaredFields();

            for (Field field : fields) {
                // 没有添加@MAutoWired，则跳过
                if (!field.isAnnotationPresent(MAutoWired.class)) {
                    continue;
                }

                MAutoWired annotation = field.getAnnotation(MAutoWired.class);
                // 若注解指定了beanName，则使用指定的beanName，否则使用字段的类型作为beanName
                String beanName = annotation.value().trim();
                if ("".equals(beanName)) {
                    beanName = field.getType().getName();
                } else {
                    beanName = this.toLowerFirstCase(beanName);
                }

                field.setAccessible(true);
                try {
                    field.set(entry.getValue(), this.ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    continue;
                }
            }
        }
    }

    /**
     * 初始化HandlerMapping
     */
    private void doInitHandlerMapping() {
        if (this.ioc.isEmpty()) {
            return;
        }

        for (Map.Entry<String, Object> entry : this.ioc.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();

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

        Map<String, String[]> parameterMap = req.getParameterMap();
        Method method = this.handlerMapping.get(url);
        String beanName = this.toLowerFirstCase(method.getDeclaringClass().getSimpleName());
        method.invoke(this.ioc.get(beanName), req, resp, parameterMap.get("name")[0], parameterMap.get("id")[0], parameterMap.get("addr")[0]);
    }
}
