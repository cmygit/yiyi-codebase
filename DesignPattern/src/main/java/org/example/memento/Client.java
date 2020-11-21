package org.example.memento;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/21 22:30
 */
public class Client {

    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState(" 状态#1 ");
        caretaker.add(originator.saveStateMemento());
        originator.setState(" 状态#2 ");
        caretaker.add(originator.saveStateMemento());
        originator.setState(" 状态#3 ");
        caretaker.add(originator.saveStateMemento());

        System.out.println("当前的状态：" + originator.getState());
        originator.getStateFromMemento(caretaker.get(0));
        System.out.println("当前的状态：" + originator.getState());
        originator.getStateFromMemento(caretaker.get(1));
        System.out.println("当前的状态：" + originator.getState());
    }
}
