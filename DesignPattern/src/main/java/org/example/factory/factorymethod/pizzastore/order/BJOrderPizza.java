package org.example.factory.factorymethod.pizzastore.order;

import org.example.factory.factorymethod.pizzastore.pizza.BJCheesePizza;
import org.example.factory.factorymethod.pizzastore.pizza.BJPepperPizza;
import org.example.factory.factorymethod.pizzastore.pizza.Pizza;


/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/23 23:43
 */
public class BJOrderPizza extends OrderPizza {

    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;

        if ("cheese".equals(orderType)) {
            pizza = new BJCheesePizza();
        } else if ("pepper".equals(orderType)) {
            pizza = new BJPepperPizza();
        }

        return pizza;
    }
}
