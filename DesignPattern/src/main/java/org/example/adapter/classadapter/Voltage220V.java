package org.example.adapter.classadapter;

/**
 * @Title: 被适配的类
 * @Author: cmy
 * @Date: 2020/9/26 18:04
 */
public class Voltage220V {

    public int output220V() {
        int src = 220;
        System.out.println("电压=" + src + "V");
        return src;
    }
}
