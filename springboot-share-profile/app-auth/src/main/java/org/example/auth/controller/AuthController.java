package org.example.auth.controller;

import org.example.auth.entity.User;
import org.example.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/9 23:32
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService service;

    @GetMapping("/hello")
    public ResponseEntity hello() {
        User user = this.service.getUser();
        return ResponseEntity.ok(user);
    }
}
