package org.example.factory.factorymethod.pizzastore.pizza;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/23 23:34
 */
public class LDCheesePizza extends Pizza {

    @Override
    public void prepare() {
        this.setName("伦敦的奶酪披萨");
        System.out.println(" 制作伦敦的奶酪披萨 准备原材料 ");
    }
}
