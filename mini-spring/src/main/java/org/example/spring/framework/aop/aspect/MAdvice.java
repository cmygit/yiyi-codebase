package org.example.spring.framework.aop.aspect;

import lombok.Data;

import java.lang.reflect.Method;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/6 20:18
 */
@Data
public class MAdvice {

    private Object aspect;

    private Method adviceMethod;

    private String throwName;

    public MAdvice(Object aspect, Method adviceMethod) {
        this.aspect = aspect;
        this.adviceMethod = adviceMethod;
    }
}
