package org.example.spring.framework.webmvc.servlet.v2;

import java.util.Map;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/8/29 15:55
 */
public class MModelAndView {

    private String viewName;

    private Map<String, ?> model;

    public MModelAndView(String viewName) {
        this.viewName = viewName;
    }

    public MModelAndView(String viewName, Map<String, ?> model) {
        this.viewName = viewName;
        this.model = model;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, ?> getModel() {
        return model;
    }

    public void setModel(Map<String, ?> model) {
        this.model = model;
    }
}
