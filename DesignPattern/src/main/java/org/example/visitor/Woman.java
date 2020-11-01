package org.example.visitor;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/1 15:10
 */
public class Woman extends Person {

    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
