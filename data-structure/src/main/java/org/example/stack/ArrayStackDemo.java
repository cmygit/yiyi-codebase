package org.example.stack;

import java.util.Scanner;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2021/1/7 20:10
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key;
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show(s): 显示栈");
            System.out.println("exit(e): 退出");
            System.out.println("push(p): 入栈");
            System.out.println("pop(pp): 出栈");
            System.out.println("请输入你的选择");

            key = scanner.next();

            switch (key) {
                case "s":
                    stack.list();
                    break;
                case "p":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pp":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "e":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出");
    }
}

/**
 * 栈
 */
class ArrayStack {

    /**
     * 栈的大小
     */
    private int maxSize;

    /**
     * 数组模拟栈，用数组存放数据
     */
    private int[] stack;

    /**
     * 栈顶
     */
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return this.top == this.maxSize - 1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public void push(int value) {
        if (this.isFull()) {
            System.out.println("栈已满，无法入栈");
            return;
        }

        this.top++;
        this.stack[this.top] = value;
    }

    public int pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("栈已空，无法出栈");
        }

        int value = this.stack[this.top];
        this.top--;

        return value;
    }

    public void list() {
        if (this.isEmpty()) {
            System.out.println("栈已空");
            return;
        }

        // 从栈顶开始遍历
        for (int i = this.top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, this.stack[i]);
        }
    }
}
