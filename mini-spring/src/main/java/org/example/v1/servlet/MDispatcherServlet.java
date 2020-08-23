package org.example.v1.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/8/22 21:08
 */
@WebServlet(name = "mmvc", urlPatterns = "/*", initParams = {
        @WebInitParam(name = "contextConfigLocation", value = "application.properties")
})
public class MDispatcherServlet extends HttpServlet {

    private Map<String ,Object> ioc = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 1、读取配置文件
        doLoadConfig();

        // 2、扫描相关的类
        doScanner();

        // 3、实例化相关的类，并且缓存到ioc容器中
        doInstance();

        // 4、完成依赖注入
        doAutoWired();

        // 5、初始化HandlerMapping
        doInitHandlerMapping();

        System.out.println("Mini Spring Framework is initialized.");
    }

    private void doLoadConfig() {

    }

    private void doScanner() {

    }

    private void doInstance() {

    }

    private void doAutoWired() {

    }

    private void doInitHandlerMapping() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req, resp);
    }

    /**
     * 调用具体的方法
     *
     * @param req
     * @param resp
     */
    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {

    }
}
