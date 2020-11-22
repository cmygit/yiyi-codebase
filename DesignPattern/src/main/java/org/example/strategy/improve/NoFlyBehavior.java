package org.example.strategy.improve;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/22 18:13
 */
public class NoFlyBehavior implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("不会飞翔~");
    }
}
