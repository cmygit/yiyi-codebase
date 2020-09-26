package org.example.bridge;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/26 23:54
 */
public abstract class Phone {

    // 组合品牌
    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    protected void open() {
        this.brand.open();
    }

    protected void close() {
        this.brand.close();
    }

    protected void call() {
        this.brand.call();
    }
}
