package org.example.uml.composition;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/22 21:31
 */
public class Person {

    /**
     * 聚合关系
     */
    private IDCard idCard;

    /**
     * 组合关系
     */
    private Head head = new Head();
}
