package org.example.queue;

import java.util.Scanner;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/24 20:44
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        // 创建队列
        CircleArray queue = new CircleArray(4);
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

/**
 * 用数组模拟环形队列
 */
class CircleArray {
    /**
     * 数组最大容量
     */
    private int maxSize;

    /**
     * 指向队列头
     */
    private int front;

    /**
     * 指向队列尾的后一个位置
     */
    private int rear;

    /**
     * 该数组用于存放数组，模拟队列
     */
    private int[] arr;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[this.maxSize];
        this.front = 0;
        this.rear = 0;
    }

    public boolean isFull() {
        // 环形结构的特点就是周而复始，而取模就是“周而复始”的体现
        return (this.rear + 1) % maxSize == this.front;
    }

    public boolean isEmpty() {
        return this.front == this.rear;
    }

    public void add(int value) {
        if (this.isFull()) {
            throw new RuntimeException("队列已满，不能添加数据~");
        }

        // 先加入数据，再将 rear 后移
        this.arr[this.rear] = value;
        this.rear = (this.rear + 1) % this.maxSize;
    }

    public int pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列为空，不能返回数据~");
        }

        // 1、先把 front 对应的值保留到临时变量中
        int value = this.arr[this.front];
        // 2、将 front 后移
        this.front = (this.front + 1) % this.maxSize;
        // 3、返回临时变量
        return value;
    }

    public void displayQueue() {
        if (this.isEmpty()) {
            System.out.println("队列为空，不能返回数据~");
            return;
        }

        // 从 front 开始遍历，遍历次数为队列有效个数
        for (int i = this.front; i < this.front + this.size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % this.maxSize, this.arr[i % this.maxSize]);
        }
    }

    /**
     * 队列长度，即队列元素有效个数
     *
     * @return
     */
    public int size() {
        return (this.rear + this.maxSize - this.front) % this.maxSize;
    }

    public int getHead() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列为空，不能返回数据~");
        }

        return this.arr[this.front];
    }
}

