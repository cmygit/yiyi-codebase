package org.example.factory.absfactory.pizzastore.order;

import org.example.factory.absfactory.pizzastore.pizza.Pizza;

/**
 * @Title: 一个抽象工厂模式的抽象层接口
 * @Author: cmy
 * @Date: 2020/9/24 21:25
 */
public interface AbsFactory {

    /**
     * 由工厂子类具体实现
     *
     * @param orderType
     * @return
     */
    Pizza createPizza(String orderType);
}
