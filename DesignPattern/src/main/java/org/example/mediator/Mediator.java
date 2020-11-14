package org.example.mediator;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/14 15:28
 */
public abstract class Mediator {

    public abstract void register(String name, Colleague colleague);

    public abstract void getMessage(int stateChange, String name);

    public abstract void sendMessage();
}
