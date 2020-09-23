package org.example.factory.factorymethod.pizzastore.order;

import org.example.factory.factorymethod.pizzastore.pizza.LDCheesePizza;
import org.example.factory.factorymethod.pizzastore.pizza.LDPepperPizza;
import org.example.factory.factorymethod.pizzastore.pizza.Pizza;


/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/23 23:43
 */
public class LDOrderPizza extends OrderPizza {

    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;

        if ("cheese".equals(orderType)) {
            pizza = new LDCheesePizza();
        } else if ("pepper".equals(orderType)) {
            pizza = new LDPepperPizza();
        }

        return pizza;
    }
}
