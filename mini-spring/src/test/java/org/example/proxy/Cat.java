package org.example.proxy;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/6 21:39
 */
public class Cat implements Animal {


    @Override
    public void say() {
        System.out.println("喵~喵~喵~");
    }

    @Override
    public void run() {
        System.out.println("跑~跑~跑~");
    }
}
