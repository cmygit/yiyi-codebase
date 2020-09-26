package org.example.adapter.classadapter;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/26 18:18
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("类适配器模式");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
