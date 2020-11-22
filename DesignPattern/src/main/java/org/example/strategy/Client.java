package org.example.strategy;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/22 16:43
 */
public class Client {

    public static void main(String[] args) {
        Duck duck1 = new WildDuck();
        Duck duck2 = new PekingDuck();
        Duck duck3 = new ToyDuck();

        duck1.display();
        duck1.quack();
        duck1.swim();
        duck1.fly();

        duck2.display();
        duck2.quack();
        duck2.swim();
        duck2.fly();

        duck3.display();
        duck3.quack();
        duck3.swim();
        duck3.fly();
    }
}
