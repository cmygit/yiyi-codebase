package org.example.factory.factorymethod.pizzastore.order;



import org.example.factory.factorymethod.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/23 20:41
 */
public abstract class OrderPizza {

    public OrderPizza() {
        Pizza pizza = null;
        String orderType;

        do {
            orderType = this.getType();
            // 抽象方法，由工厂子类实现
            pizza = this.createPizza(orderType);

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
     * 定义一个抽象方法， createPizza ，让各个工厂子类自己实现
     *
     * @param orderType
     * @return
     */
    public abstract org.example.factory.factorymethod.pizzastore.pizza.Pizza createPizza(String orderType);

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
