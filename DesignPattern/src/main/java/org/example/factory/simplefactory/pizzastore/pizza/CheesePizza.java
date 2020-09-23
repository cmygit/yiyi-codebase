package org.example.factory.simplefactory.pizzastore.pizza;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/23 20:38
 */
public class CheesePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println(" 制作奶酪披萨 准备原材料 ");
    }
}
