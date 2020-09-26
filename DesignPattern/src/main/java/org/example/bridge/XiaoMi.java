package org.example.bridge;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/26 23:52
 */
public class XiaoMi implements Brand {

    @Override
    public void open() {
        System.out.println(" 小米手机开机 ");
    }

    @Override
    public void close() {
        System.out.println(" 小米手机关机 ");
    }

    @Override
    public void call() {
        System.out.println(" 小米手机打电话 ");
    }
}
