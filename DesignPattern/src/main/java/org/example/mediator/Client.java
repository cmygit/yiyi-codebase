package org.example.mediator;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/14 15:50
 */
public class Client {

    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Alarm alarm = new Alarm(mediator, "Alarm");
        alarm.sendAlarm(0);
        alarm.sendAlarm(1);
    }
}
