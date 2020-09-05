package org.example.demo.service.impl;

import org.example.demo.service.IModifyService;
import org.example.spring.framework.annotation.MService;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/5 16:01
 */
@MService
public class ModifyServiceImpl implements IModifyService {

    @Override
    public String add(String name, String addr) {
        throw new RuntimeException("业务发生异常");
    }

    @Override
    public String edit(Integer id, String name) {
        return "edit: id = " + id + ", name = " + name;
    }

    @Override
    public String calc(Integer a, Integer b) {
        return String.valueOf(a + b);
    }

    @Override
    public String remove(Integer id) {
        return "remove: " + id;
    }
}
