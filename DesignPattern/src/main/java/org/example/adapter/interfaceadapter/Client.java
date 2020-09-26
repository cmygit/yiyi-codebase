package org.example.adapter.interfaceadapter;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/26 20:07
 */
public class Client {

    public static void main(String[] args) {
        AbsAdapter adapter = new AbsAdapter() {
            /**
             * 可选择实现其中的某些方法，而不是全部方法
             */
            @Override
            public void m1() {
                System.out.println("使用了m1的方法");
            }
        };

        adapter.m1();
    }
}
