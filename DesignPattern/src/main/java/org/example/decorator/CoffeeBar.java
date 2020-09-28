package org.example.decorator;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/28 21:22
 */
public class CoffeeBar {

    public static void main(String[] args) {
        // 装饰者模式的订单：2份巧克力 + 一份牛奶的 LongBlack

        // 1、点一份 LongBlack
        Drink order = new Espresso();
        System.out.println("费用1：" + order.cost());
        System.out.println("描述：" + order.getDes());

        // 2、加一份牛奶
        order = new Milk(order);
        System.out.println("费用2：" + order.cost());
        System.out.println("描述：" + order.getDes());

        // 3、加一份巧克力
        order = new Chocolate(order);
        System.out.println("费用3：" + order.cost());
        System.out.println("描述：" + order.getDes());

        // 4、再加一份巧克力
        order = new Chocolate(order);
        System.out.println("费用3：" + order.cost());
        System.out.println("描述：" + order.getDes());
    }
}
