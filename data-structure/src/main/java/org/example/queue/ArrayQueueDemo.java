package org.example.queue;

import java.util.Scanner;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/24 20:44
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        // 创建队列
        ArrayQueue queue = new ArrayQueue(3);
        // 接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("p(pop): 弹出队列头的数据");
            System.out.println("h(head)：获取队列头的数据");

            // 接收一个字符
            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    queue.displayQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;
                case 'p':
                    try {
                        int result = queue.pop();
                        System.out.printf("取出的数据是%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result = queue.getHead();
                        System.out.printf("队列头的数据是%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
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

class ArrayQueue {

    /**
     * 数组最大容量
     */
    private int maxSize;

    /**
     * 指向队列头的前一个位置
     */
    private int front;

    /**
     * 指向队列尾的位置
     */
    private int rear;

    /**
     * 该数组用于存放数组，模拟队列
     */
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[this.maxSize];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isFull() {
        return this.rear == this.maxSize - 1;
    }

    public boolean isEmpty() {
        return this.front == this.rear;
    }

    public void add(int value) {
        if (this.isFull()) {
            throw new RuntimeException("队列已满，不能添加数据~");
        }

        this.rear++;
        this.arr[this.rear] = value;
    }

    public int pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列为空，不能返回数据~");
        }

        this.front++;
        return this.arr[this.front];
    }

    public void displayQueue() {
        if (this.isEmpty()) {
            System.out.println("队列为空，不能返回数据~");
            return;
        }

        for (int i = 0; i < this.arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, this.arr[i]);
        }
    }

    public int getHead() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列为空，不能返回数据~");
        }

        return this.arr[this.front + 1];
    }
}
