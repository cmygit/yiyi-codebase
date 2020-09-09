package org.example.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/9 21:59
 */
@SpringBootApplication(scanBasePackages = {"org.example.business", "org.example.auth"})
@MapperScan(basePackages = {"org.example.business.mapper", "org.example.auth.mapper"})
public class StartApp {

    public static void main(String[] args) {
        SpringApplication.run(StartApp.class);
    }
}
