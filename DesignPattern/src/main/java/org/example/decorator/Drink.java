package org.example.decorator;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/28 20:20
 */
public abstract class Drink {

    public String des;

    private float price = 0.0f;

    public abstract float cost();

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
