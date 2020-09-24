package org.example.factory.absfactory.pizzastore.order;

import org.example.factory.absfactory.pizzastore.pizza.BJCheesePizza;
import org.example.factory.absfactory.pizzastore.pizza.BJPepperPizza;
import org.example.factory.absfactory.pizzastore.pizza.Pizza;

/**
 * @Title: 工厂子类
 * @Author: cmy
 * @Date: 2020/9/24 21:27
 */
public class BJFactory implements AbsFactory {

    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("使用抽象工厂模式");
        Pizza pizza = null;

        if ("cheese".equals(orderType)) {
            pizza = new BJCheesePizza();
        } else if ("pepper".equals(orderType)) {
            pizza = new BJPepperPizza();
        }

        return pizza;
    }
}
