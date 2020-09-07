package org.example.spring.framework.aop.config;

import lombok.Data;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/6 20:18
 */
@Data
public class MAopConfig {

    /**
     * 切面表达式
     */
    private String pointCut;

    /**
     * 切面类
     */
    private String aspectClass;

    /**
     * 切面前置通知
     */
    private String aspectBefore;

    /**
     * 切面后置通知
     */
    private String aspectAfter;

    /**
     * 切面异常通知
     */
    private String aspectAfterThrow;

    /**
     * 切面异常类型
     */
    private String aspectAfterThrowingName;
}
