package org.example.visitor;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/1 15:10
 */
public abstract class Person {

    public abstract void accept(Action action);
}
