package org.example.bridge;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/26 23:56
 */
public class UpRightPhone extends Phone {

    public UpRightPhone(Brand brand) {
        super(brand);
    }

    public void open() {
        super.open();
        System.out.println(" 直立样式样式手机 ");
    }

    public void close() {
        super.close();
        System.out.println(" 直立样式样式手机 ");
    }

    public void call() {
        super.call();
        System.out.println(" 直立样式样式手机 ");
    }
}
