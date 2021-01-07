package org.example.stack;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2021/1/7 20:10
 */
public class ArrayStackDemo {
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
            System.out.println("栈已空，无法出栈");
            return;
        }

        // 从栈顶开始遍历
        for (int i = this.top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, this.stack[i]);
        }
    }
}
