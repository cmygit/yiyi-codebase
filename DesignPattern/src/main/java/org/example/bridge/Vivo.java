package org.example.bridge;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/26 23:53
 */
public class Vivo implements Brand {

    @Override
    public void open() {
        System.out.println(" vivo手机开机 ");
    }

    @Override
    public void close() {
        System.out.println(" vivo手机关机 ");
    }

    @Override
    public void call() {
        System.out.println(" vivo手机打电话 ");
    }
}
