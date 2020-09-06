package org.example;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/8/23 20:35
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        log.trace("hello world");
        log.debug("hello world");
        log.info("hello world");
        log.warn("hello world");
        log.error("hello world");
    }
}
