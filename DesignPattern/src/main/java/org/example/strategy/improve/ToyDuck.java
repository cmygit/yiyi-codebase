package org.example.strategy.improve;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/22 18:17
 */
public class ToyDuck extends Duck {

    public ToyDuck() {
        super.flyBehavior = new NoFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println(" 这是玩具鸭 ");
    }
}
