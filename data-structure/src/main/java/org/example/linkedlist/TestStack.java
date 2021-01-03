package org.example.linkedlist;

import java.util.Stack;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2021/1/3 22:22
 */
public class TestStack {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
