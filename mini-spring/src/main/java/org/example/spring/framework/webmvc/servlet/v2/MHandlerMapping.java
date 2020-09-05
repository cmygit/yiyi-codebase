package org.example.spring.framework.webmvc.servlet.v2;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/8/29 15:55
 */
public class MHandlerMapping {

    private Pattern pattern;

    private Method method;

    private Object controller;

    public MHandlerMapping(Pattern pattern, Method method, Object controller) {
        this.pattern = pattern;
        this.method = method;
        this.controller = controller;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }
}
