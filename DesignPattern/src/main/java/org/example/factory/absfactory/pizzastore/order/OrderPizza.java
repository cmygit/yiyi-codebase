package org.example.factory.absfactory.pizzastore.order;

import org.example.factory.absfactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/24 21:40
 */
public class OrderPizza {

    AbsFactory factory;

    public OrderPizza(AbsFactory factory) {
        this.setFactory(factory);
    }

    private void setFactory(AbsFactory factory) {
        Pizza pizza = null;
        String orderType = "";
        this.factory = factory;

        do {
            orderType = this.getType();
            pizza = this.factory.createPizza(orderType);

            // 制作披萨
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println(" 订购披萨失败 ");
                break;
            }
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
