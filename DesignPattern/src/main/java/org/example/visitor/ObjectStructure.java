package org.example.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/1 15:19
 */
public class ObjectStructure {

    private List<Person> persons = new LinkedList<>();

    public void attach(Person person) {
        this.persons.add(person);
    }

    public void detach(Person person) {
        this.persons.remove(person);
    }

    public void display(Action action) {
        for (Person person : this.persons) {
            person.accept(action);
        }
    }
}
