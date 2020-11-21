package org.example.memento;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/21 22:24
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
