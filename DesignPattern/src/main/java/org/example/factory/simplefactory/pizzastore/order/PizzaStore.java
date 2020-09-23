package org.example.factory.simplefactory.pizzastore.order;

/**
 * @Title: 相当于客户端，发出订购
 * @Author: cmy
 * @Date: 2020/9/23 20:54
 */
public class PizzaStore {

    public static void main(String[] args) {
        // 使用简单工厂模式
        // new OrderPizza(new SimpleFactory());

        // 使用静态工厂模式
        new OrderPizza2();

        System.out.println("exit...");
    }
}
