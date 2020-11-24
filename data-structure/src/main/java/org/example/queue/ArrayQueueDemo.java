package org.example.queue;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/24 20:44
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {

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

    public void add(int item) {
        if (this.isFull()) {
            throw new RuntimeException("队列已满，不能添加数据~");
        }

        this.rear++;
        this.arr[this.rear] = item;
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
