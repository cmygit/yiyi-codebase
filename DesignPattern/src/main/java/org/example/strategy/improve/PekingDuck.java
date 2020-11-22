package org.example.strategy.improve;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/22 18:15
 */
public class PekingDuck extends Duck {

    public PekingDuck() {
        super.flyBehavior = new BadFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println(" 这是北京鸭 ");
    }
}
