package org.example.factory.simplefactory.pizzastore.order;

import org.example.factory.simplefactory.pizzastore.pizza.CheesePizza;
import org.example.factory.simplefactory.pizzastore.pizza.GreekPizza;
import org.example.factory.simplefactory.pizzastore.pizza.PepperPizza;
import org.example.factory.simplefactory.pizzastore.pizza.Pizza;

/**
 * @Title: 简单工厂类
 * @Author: cmy
 * @Date: 2020/9/23 23:03
 */
public class SimpleFactory {

    /**
     * 根据 orderType 返回对应的Pizza对象
     *
     * @param orderType
     * @return
     */
    public Pizza createPizza(String orderType) {
        System.out.println("使用简单工厂模式");

        Pizza pizza = null;

        if ("greek".equals(orderType)) {
            pizza = new GreekPizza();
        } else if ("cheese".equals(orderType)) {
            pizza = new CheesePizza();
        } else if ("pepper".equals(orderType)) {
            pizza = new PepperPizza();
        }

        if (pizza != null) {
            pizza.setName(orderType + " pizza");
        }

        return pizza;
    }
}
