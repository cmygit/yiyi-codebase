package org.example.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/21 22:29
 */
public class Caretaker {

    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento) {
        this.mementoList.add(memento);
    }

    public Memento get(int index) {
        return this.mementoList.get(index);
    }
}
