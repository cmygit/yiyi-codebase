package org.example.facade;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/10/3 12:01
 */
public class Stereo {

    private static Stereo instance = new Stereo();

    public static Stereo getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(" stereo on ");
    }

    public void off() {
        System.out.println(" stereo off ");
    }

    public void up() {
        System.out.println(" stereo up ");
    }

    public void down() {
        System.out.println(" stereo down ");
    }
}
