package org.example.linkedlist;

/**
 * @Title: 约瑟夫环
 * @Author: cmy
 * @Date: 2021/1/5 21:40
 */
public class Joseph {

    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        int nums = 6;
        list.addBoy(nums);
        list.show();

        list.countBoy(1, 5, nums);
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

    /**
     * 约瑟夫环 出圈
     *
     * @param startNo  表示从第几个小孩开始报数
     * @param countNum 表示数几下为一轮
     * @param nums     表示最初有多少个小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (this.first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }

        // helper 指向最后一个节点，跟 first 指针同时移动
        Boy helper = this.first;

        // 初始化 helper，将 helper 指向最后一个节点
        while (true) {
            // 判断是否遍历到最后一个节点
            if (helper.getNext() == this.first) {
                break;
            }

            // 移位
            helper = helper.getNext();
        }

        // 移动到开始报数的位置
        for (int i = 0; i < startNo - 1; i++) {
            this.first = this.first.getNext();
            helper = helper.getNext();
        }

        // 报数
        // 每报数一轮，将 first 指向的节点移出链表（出圈），直到只剩下最后一个节点
        while (true) {
            // 判断是否只剩下最后一个节点
            if (helper == this.first) {
                break;
            }

            // 移动一轮
            for (int i = 0; i < countNum - 1; i++) {
                this.first = this.first.getNext();
                helper = helper.getNext();
            }

            // 出圈
            System.out.printf("小孩 %d 出圈\n", this.first.getNo());
            // 重新闭环
            this.first = first.getNext();
            helper.setNext(this.first);
        }
        // 最后的小孩
        System.out.printf("最后的小孩 %d\n", this.first.getNo());
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
