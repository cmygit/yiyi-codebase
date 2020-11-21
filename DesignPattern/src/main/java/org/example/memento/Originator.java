package org.example.memento;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/21 22:23
 */
public class Originator {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateMemento() {
        return new Memento(this.getState());
    }

    public void getStateFromMemento(Memento memento) {
        this.setState(memento.getState());
    }
}
