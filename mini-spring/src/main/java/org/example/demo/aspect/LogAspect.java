package org.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/6 15:56
 */
@Slf4j
public class LogAspect {

    /**
     * 调用一个方法前，先执行此方法
     */
    public void before() {
        log.info("Invoke Before Method...");
    }

    /**
     * 调用一个方法后，再执行此方法
     */
    public void after() {
        log.info("Invoke After Method...");
    }

    /**
     * 调用一个方法出现异常时，执行此方法
     */
    public void afterThrowing() {
        log.info("Invoke AfterThrowing Method...");
    }
}
