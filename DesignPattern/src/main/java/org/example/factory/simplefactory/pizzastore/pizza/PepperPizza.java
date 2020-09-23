package org.example.factory.simplefactory.pizzastore.pizza;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/23 22:50
 */
public class PepperPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println(" 制作胡椒披萨 准备原材料 ");
    }
}
