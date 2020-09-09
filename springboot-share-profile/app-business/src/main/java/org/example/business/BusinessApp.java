package org.example.business;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/9 23:13
 */
@SpringBootApplication()
@MapperScan(basePackages = {"org.example.business.mapper"})
public class BusinessApp {

    public static void main(String[] args) {
        SpringApplication.run(BusinessApp.class);
    }
}
