package org.example.factory.absfactory.pizzastore.order;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/24 21:47
 */
public class PizzaStore {

    public static void main(String[] args) {
        // new OrderPizza(new BJFactory());
        new OrderPizza(new LDFactory());
    }
}
