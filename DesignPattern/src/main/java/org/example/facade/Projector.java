package org.example.facade;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/10/3 11:59
 */
public class Projector {

    private static Projector instance = new Projector();

    public static Projector getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(" projector on ");
    }

    public void off() {
        System.out.println(" projector off ");
    }

    public void focus() {
        System.out.println(" projector is focusing ");
    }
}
