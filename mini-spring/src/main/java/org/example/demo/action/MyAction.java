package org.example.demo.action;

import org.example.demo.service.IModifyService;
import org.example.demo.service.IQueryService;
import org.example.spring.framework.annotation.MAutoWired;
import org.example.spring.framework.annotation.MController;
import org.example.spring.framework.annotation.MRequestMapping;
import org.example.spring.framework.annotation.MRequestParam;
import org.example.spring.framework.webmvc.servlet.v2.MModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/5 15:59
 */
@MController
@MRequestMapping("/web")
public class MyAction {

    @MAutoWired
    private IQueryService queryService;

    @MAutoWired
    private IModifyService modifyService;

    @MRequestMapping("/query*.json")
    public void query(HttpServletRequest request, HttpServletResponse response, @MRequestParam("name") String name) {
        String result = this.queryService.query(name);
        this.out(response, result);
    }

    @MRequestMapping("/add*.json")
    public MModelAndView add(HttpServletRequest request, HttpServletResponse response,
                             @MRequestParam("name") String name, @MRequestParam("addr") String addr) {
        String result = this.modifyService.add(name, addr);
        return this.out(response, result);
    }

    @MRequestMapping("/remove.json")
    public MModelAndView remove(HttpServletRequest request, HttpServletResponse response,
                                @MRequestParam("id") Integer id) {
        String result = this.modifyService.remove(id);
        return this.out(response, result);
    }

    @MRequestMapping("/calc.json")
    public MModelAndView calc(HttpServletResponse response,
                              @MRequestParam("a") Integer a, @MRequestParam Integer b) {
        String result = this.modifyService.calc(a, b);
        return this.out(response, result);
    }

    @MRequestMapping("/edit.json")
    public MModelAndView edit(HttpServletRequest request, HttpServletResponse response,
                              @MRequestParam("id") Integer id, @MRequestParam("name") String name) {
        String result = this.modifyService.edit(id, name);
        return this.out(response, result);
    }

    private MModelAndView out(HttpServletResponse response, String result) {
        try {
            response.getWriter()
                    .write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
