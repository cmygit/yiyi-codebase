package org.example.strategy.improve;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/22 16:39
 */
public abstract class Duck {

    FlyBehavior flyBehavior;

    public Duck() {
    }

    public abstract void display();

    public void quack() {
        System.out.println("鸭子嘎嘎叫~");
    }

    public void swim() {
        System.out.println("鸭子会游泳~");
    }

    public void fly() {
        if (this.flyBehavior != null) {
            this.flyBehavior.fly();
        } else {
            System.out.println("鸭子会飞行~");
        }
    }
}
