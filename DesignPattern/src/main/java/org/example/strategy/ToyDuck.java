package org.example.strategy;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/22 16:42
 */
public class ToyDuck extends Duck {

    @Override
    public void display() {
        System.out.println(" 这是玩具鸭 ");
    }

    @Override
    public void quack() {
        System.out.println("鸭子不会嘎嘎叫~");
    }

    @Override
    public void swim() {
        System.out.println("鸭子不会游泳~");
    }

    @Override
    public void fly() {
        System.out.println("鸭子不会飞行~");
    }
}
