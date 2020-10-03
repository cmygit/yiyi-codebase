package org.example.facade;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/10/3 12:00
 */
public class Screen {

    private static Screen instance = new Screen();

    public static Screen getInstance() {
        return instance;
    }

    public void up() {
        System.out.println(" screen up ");
    }

    public void down() {
        System.out.println(" screen down ");
    }
}
