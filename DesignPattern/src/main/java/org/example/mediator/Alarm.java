package org.example.mediator;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/14 15:37
 */
public class Alarm extends Colleague {

    public Alarm(Mediator mediator, String name) {
        super(mediator, name);
        this.getMediator().register(name, this);
    }

    public void sendAlarm(int stateChange) {
        this.sendMessage(stateChange);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator()
            .getMessage(stateChange, this.getName());
    }
}
