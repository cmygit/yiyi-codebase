package org.example.demo.action;

import org.example.demo.service.IDemoService;
import org.example.mvcframework.v1.annotation.MAutoWired;
import org.example.mvcframework.v1.annotation.MController;
import org.example.mvcframework.v1.annotation.MRequestMapping;
import org.example.mvcframework.v1.annotation.MRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/8/23 18:01
 */
@MController
@MRequestMapping("/demo")
public class DemoAction {

    @MAutoWired
    private IDemoService demoService;

    @MAutoWired
    private IDemoService demoService2;

    @MRequestMapping("/query")
    public void query(HttpServletRequest req,
                      HttpServletResponse resp,
                      @MRequestParam("name") String name,
                      @MRequestParam("id") String id,
                      @MRequestParam("addr") String addr) {
        String result = "My name is " + name + ", id = " + id + ", addr =" + addr;
        try {
            resp.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
