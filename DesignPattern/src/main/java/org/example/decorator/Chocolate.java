package org.example.decorator;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/28 21:16
 */
public class Chocolate extends Decorator {

    public Chocolate(Drink drink) {
        super(drink);
        super.setDes(" 巧克力 ");
        super.setPrice(3.0f);
    }
}
