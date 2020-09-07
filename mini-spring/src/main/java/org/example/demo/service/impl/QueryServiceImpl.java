package org.example.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.demo.service.IQueryService;
import org.example.spring.framework.annotation.MService;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/5 16:00
 */
@MService
@Slf4j
public class QueryServiceImpl implements IQueryService {

    @Override
    public String query(String name) {
        log.info("query...");
        return "name: " + name;
    }
}
