package org.example.factory.simplefactory.pizzastore.pizza;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/23 20:40
 */
public class GreekPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println(" 制作希腊披萨 准备原材料 ");
    }
}
