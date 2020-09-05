package org.example.demo.service;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/5 16:00
 */
public interface IModifyService {

    String add(String name, String addr);

    String edit(Integer id, String name);

    String calc(Integer a, Integer b);

    String remove(Integer id);
}
