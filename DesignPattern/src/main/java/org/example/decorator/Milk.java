package org.example.decorator;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/28 21:18
 */
public class Milk extends Decorator {

    public Milk(Drink drink) {
        super(drink);
        super.setDes(" 牛奶 ");
        super.setPrice(2.0f);
    }
}
