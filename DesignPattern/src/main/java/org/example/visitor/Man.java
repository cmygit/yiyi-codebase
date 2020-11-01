package org.example.visitor;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/1 15:08
 */
public class Man extends Person {

    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
