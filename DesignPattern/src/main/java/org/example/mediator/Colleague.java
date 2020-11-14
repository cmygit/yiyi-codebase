package org.example.mediator;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/14 15:27
 */
public abstract class Colleague {

    private Mediator mediator;

    private String name;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public String getName() {
        return name;
    }

    public abstract void sendMessage(int stateChange);
}
