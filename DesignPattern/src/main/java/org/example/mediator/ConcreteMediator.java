package org.example.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/14 15:42
 */
public class ConcreteMediator extends Mediator {

    private Map<String, Colleague> colleagueMap;

    private Map<String, String> interMap;

    public ConcreteMediator() {
        this.colleagueMap = new HashMap<>();
        this.interMap = new HashMap<>();
    }


    @Override
    public void register(String name, Colleague colleague) {
        this.colleagueMap.put(name, colleague);

        if (colleague instanceof Alarm) {
            this.interMap.put("Alarm", name);
        }
    }

    @Override
    public void getMessage(int stateChange, String name) {
        if (this.colleagueMap.get(name) instanceof Alarm) {
            System.out.println("===接收到信号：" + stateChange + "===");
        }
    }

    @Override
    public void sendMessage() {

    }
}
