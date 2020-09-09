package org.example.auth.service;

import lombok.extern.slf4j.Slf4j;
import org.example.auth.AuthAppTest;
import org.example.auth.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/9 23:15
 */
@Slf4j
public class UserServiceTest extends AuthAppTest {

    @Autowired
    private UserService service;

    @Test
    public void getUser() {
        User user = this.service.getUser();
        assertNotNull(user);
        log.info(user.toString());
    }
}
