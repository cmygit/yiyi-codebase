package org.example.factory.factorymethod.pizzastore.pizza;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/23 23:34
 */
public class BJPepperPizza extends Pizza {

    @Override
    public void prepare() {
        this.setName("北京的胡椒披萨");
        System.out.println(" 制作北京的胡椒披萨 准备原材料 ");
    }
}
