package org.example.auth.service;

import org.example.auth.entity.User;
import org.example.auth.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/9 23:13
 */
@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    public User getUser() {
        return this.mapper.selectById(1);
    }
}
