package org.example.log;

import lombok.extern.slf4j.Slf4j;
import org.example.AppTest;
import org.junit.Test;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/1 20:08
 */
@Slf4j
public class LogTest extends AppTest {

    @Test
    public void hello() {
        log.info("hello.");
        log.error("hello.");
        log.warn("hello.");
        // 默认不输出
        log.debug("hello.");
        log.trace("hello.");
    }
}
