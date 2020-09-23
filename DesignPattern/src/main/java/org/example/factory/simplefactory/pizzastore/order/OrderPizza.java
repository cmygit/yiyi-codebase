package org.example.factory.simplefactory.pizzastore.order;

import org.example.factory.simplefactory.pizzastore.pizza.CheesePizza;
import org.example.factory.simplefactory.pizzastore.pizza.GreekPizza;
import org.example.factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/23 20:41
 */
public class OrderPizza {

    public OrderPizza() {
        Pizza pizza = null;
        // 订购披萨的类型
        String orderType = "";

        do {
            orderType = this.getType();

            if ("greek".equals(orderType)) {
                pizza = new GreekPizza();
            } else if ("cheese".equals(orderType)) {
                pizza = new CheesePizza();
            } else {
                break;
            }

            // 输出 pizza 制作过程
            pizza.setName(orderType);
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } while (true);
    }

    /**
     * 获取客户希望订购的披萨种类
     *
     * @return
     */
    private String getType() {
        BufferedReader strIn = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input pizza 种类：");
        String str = "";

        try {
            str = strIn.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }
}
