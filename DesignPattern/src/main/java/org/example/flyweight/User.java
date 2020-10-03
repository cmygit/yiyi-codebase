package org.example.flyweight;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/10/3 23:18
 */
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
