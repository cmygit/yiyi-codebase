package org.example.strategy;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/22 16:41
 */
public class PekingDuck extends Duck {

    @Override
    public void display() {
        System.out.println(" 这是北京鸭 ");
    }

    @Override
    public void fly() {
        System.out.println("鸭子不会飞行~");
    }
}
