package org.example.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/9 22:02
 */
@SpringBootApplication
@MapperScan(basePackages = {"org.example.auth.mapper"})
public class AuthApp {

    public static void main(String[] args) {
        SpringApplication.run(AuthApp.class);
    }
}
