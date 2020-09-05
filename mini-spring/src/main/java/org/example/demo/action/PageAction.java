package org.example.demo.action;

import org.example.demo.service.IQueryService;
import org.example.spring.framework.annotation.MAutoWired;
import org.example.spring.framework.annotation.MController;
import org.example.spring.framework.annotation.MRequestMapping;
import org.example.spring.framework.annotation.MRequestParam;
import org.example.spring.framework.webmvc.servlet.v2.MModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/5 16:18
 */
@MController
@MRequestMapping("/")
public class PageAction {

    @MAutoWired
    private IQueryService queryService;

    @MRequestMapping("/first.html")
    public MModelAndView query(@MRequestParam("user") String user) {
        String result = this.queryService.query(user);

        Map<String, Object> model = new HashMap<>();
        model.put("user", user);
        model.put("data", result);
        model.put("token", "123456");
        return new MModelAndView("first.html", model);
    }
}
