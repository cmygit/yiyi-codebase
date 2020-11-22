package org.example.strategy.improve;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/22 18:12
 */
public class BadFlyBehavior implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("飞翔技术一般~");
    }
}
