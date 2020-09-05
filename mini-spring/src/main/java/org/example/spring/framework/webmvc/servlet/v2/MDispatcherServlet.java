package org.example.spring.framework.webmvc.servlet.v2;

import org.example.spring.framework.annotation.MController;
import org.example.spring.framework.annotation.MRequestMapping;
import org.example.spring.framework.context.MApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private List<MHandlerMapping> handlerMappings = new ArrayList<>();

    private Map<MHandlerMapping, MHandlerAdapter> handlerAdapters = new HashMap<>();

    private List<MViewResolver> viewResolvers = new ArrayList<>();

    @Override
    public void init(ServletConfig config) {
        // IOC
        this.context = new MApplicationContext(config.getInitParameter("contextConfigLocation"));

        // MVC
        // 初始化HandlerMapping
        this.initStrategies(this.context);

        System.out.println("Mini Spring Framework is initialized.");
    }

    private void initStrategies(MApplicationContext context) {
        this.initHandlerMappings(context);

        this.initHandlerAdapters(context);

        this.initViewResolvers(context);
    }

    private void initViewResolvers(MApplicationContext context) {
        String templateRoot = context.getConfig()
                                     .getProperty("templateRoot");

        String templateRootPath = this.getClass()
                                      .getClassLoader()
                                      .getResource(templateRoot)
                                      .getFile();

        File templateRootDir = new File(templateRootPath);

        for (File templateFile : templateRootDir.listFiles()) {
            this.viewResolvers.add(new MViewResolver(templateRoot));
        }
    }

    private void initHandlerAdapters(MApplicationContext context) {
        for (MHandlerMapping handlerMapping : this.handlerMappings) {
            this.handlerAdapters.put(handlerMapping, new MHandlerAdapter());
        }
    }

    private void initHandlerMappings(MApplicationContext context) {
        if (this.context.getDefinitionCount() == 0) {
            return;
        }

        Set<String> beanNames = this.context.getDefinitionNames();

        for (String beanName : beanNames) {
            Object instance = this.context.getBean(beanName);
            Class<?> clazz = instance.getClass();

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

                String regex = "/" + baseUrl + "/" + annotation.value();
                // 将 * 转为正则表达式的 *
                regex = regex.replaceAll("\\*", ".*")
                             // 去除重复的“/”
                             .replaceAll("/+", "/");

                Pattern pattern = Pattern.compile(regex);

                this.handlerMappings.add(new MHandlerMapping(pattern, method, instance));
                System.out.println("Mapped: " + regex + "," + method);
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
            this.doDispatch(req, resp);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();

            Map<String, Object> model = new HashMap<>();
            model.put("detail", "500 Exception Detail");
            model.put("stackTrace", Arrays.toString(e.getStackTrace()));

            this.processDispatchResult(req, resp, new MModelAndView("500", model));
        }
    }

    /**
     * 调用具体的方法
     *
     * @param req  request
     * @param resp response
     */
    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, IOException {
        // 1、根据URL去拿到对应的HandlerMapping
        MHandlerMapping handlerMapping = this.getHandler(req);
        // 如果HandlerMapping为null，则返回404
        if (handlerMapping == null) {
            Map<String, Object> model = new HashMap<>();
            model.put("msg", "404 NOT FOUND");

            this.processDispatchResult(req, resp, new MModelAndView("404", model));
            return;
        }

        // 2、根据HandlerMapping获取对应的HandlerAdapter
        MHandlerAdapter handlerAdapter = this.getHandleAdapter(handlerMapping);

        // 3、根据HandlerAdapter的返回结果判断
        MModelAndView modelAndView = handlerAdapter.handle(req, resp, handlerMapping);

        // 4、根据ModelAndView，决定选择用那个ViewResolver去解析
        this.processDispatchResult(req, resp, modelAndView);
    }

    private MHandlerAdapter getHandleAdapter(MHandlerMapping handlerMapping) {
        if (this.handlerAdapters.isEmpty()) {
            return null;
        }
        return this.handlerAdapters.get(handlerMapping);
    }

    private void processDispatchResult(HttpServletRequest req, HttpServletResponse resp, MModelAndView modelAndView) throws IOException {
        if (modelAndView == null) {
            return;
        }

        if (this.viewResolvers.isEmpty()) {
            return;
        }

        for (MViewResolver viewResolver : this.viewResolvers) {
            MView view = viewResolver.resolve(modelAndView.getViewName());
            if (view == null) {
                continue;
            }

            view.render(modelAndView.getModel(), req, resp);
            break;
        }
    }

    private MHandlerMapping getHandler(HttpServletRequest req) {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = ("/" + url).replaceAll(contextPath, "")
                         .replaceAll("/+", "/");

        for (MHandlerMapping handlerMapping : this.handlerMappings) {
            Matcher matcher = handlerMapping.getPattern().matcher(url);
            if (!matcher.matches()) {
                continue;
            }
            return handlerMapping;
        }

        return null;
    }
}
