package org.example.uml.composition;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/22 21:20
 */
public class Computer {

    /**
     * mouse 不可以和 computer 分离
     */
    private Mouse mouse = new Mouse();

    /**
     * monitor 不可以和 computer 分离
     */
    private Monitor monitor = new Monitor();
}
