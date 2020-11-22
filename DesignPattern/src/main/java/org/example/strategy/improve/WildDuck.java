package org.example.strategy.improve;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/22 18:15
 */
public class WildDuck extends Duck {

    public WildDuck() {
        super.flyBehavior = new GoodFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println(" 这是野鸭 ");
    }
}
