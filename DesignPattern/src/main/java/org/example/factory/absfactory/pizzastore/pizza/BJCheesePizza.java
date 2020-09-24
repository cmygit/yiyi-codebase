package org.example.factory.absfactory.pizzastore.pizza;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/23 23:34
 */
public class BJCheesePizza extends Pizza {

    @Override
    public void prepare() {
        this.setName("北京的奶酪披萨");
        System.out.println(" 制作北京的奶酪披萨 准备原材料 ");
    }
}
