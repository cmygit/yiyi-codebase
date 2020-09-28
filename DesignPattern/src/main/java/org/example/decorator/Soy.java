package org.example.decorator;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/28 21:20
 */
public class Soy extends Decorator {

    public Soy(Drink drink) {
        super(drink);
        super.setDes(" 豆浆 ");
        super.setPrice(1.5f);
    }
}
