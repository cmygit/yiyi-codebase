package org.example.linkedlist;

/**
 * @Title: 约瑟夫环
 * @Author: cmy
 * @Date: 2021/1/5 21:40
 */
public class Joseph {

    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.addBoy(25);
        list.show();
    }
}

/**
 * 环形链表
 */
class CircleSingleLinkedList {

    private Boy first = new Boy(-1);

    /**
     * 创建环形链表
     *
     * @param nums 链表元素个数
     */
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("num的值必须大于等于1");
            return;
        }

        Boy curBoy = null;

        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);

            if (i == 1) {
                this.first = boy;
                // 闭环
                this.first.setNext(this.first);
                // 指向最新元素
                curBoy = this.first;
            } else {
                // 链接下一个元素
                curBoy.setNext(boy);
                // 闭环
                boy.setNext(this.first);
                // 指向最新元素
                curBoy = boy;
            }
        }
    }

    public void show() {
        if (this.first == null) {
            System.out.println("没有任何小孩~~");
            return;
        }

        Boy curBoy = this.first;
        while (true) {
            System.out.printf("小孩的编号：%d\n", curBoy.getNo());

            // 判断是否遍历到最后一个元素
            if (curBoy.getNext() == this.first) {
                break;
            }

            // 移位
            curBoy = curBoy.getNext();
        }
    }
}

class Boy {

    private int no;

    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
