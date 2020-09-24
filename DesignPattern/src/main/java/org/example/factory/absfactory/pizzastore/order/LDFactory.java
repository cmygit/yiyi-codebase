package org.example.factory.absfactory.pizzastore.order;


import org.example.factory.absfactory.pizzastore.pizza.LDCheesePizza;
import org.example.factory.absfactory.pizzastore.pizza.LDPepperPizza;
import org.example.factory.absfactory.pizzastore.pizza.Pizza;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/24 21:37
 */
public class LDFactory implements AbsFactory {

    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("使用抽象工厂模式");
        Pizza pizza = null;

        if ("cheese".equals(orderType)) {
            pizza = new LDCheesePizza();
        } else if ("pepper".equals(orderType)) {
            pizza = new LDPepperPizza();
        }

        return pizza;
    }
}
