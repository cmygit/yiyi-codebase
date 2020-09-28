package org.example.decorator;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/28 21:11
 */
public class Decorator extends Drink {

    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        // drink.cost() 递归调用
        return super.getPrice() + drink.cost();
    }

    @Override
    public String getDes() {
        // drink.getDes() 递归调用
        return super.getDes() + " " + super.getPrice()+" && " + drink.getDes();
    }
}
