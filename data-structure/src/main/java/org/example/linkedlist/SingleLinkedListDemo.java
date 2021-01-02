package org.example.linkedlist;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2021/1/2 21:55
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "1", "11");
        HeroNode node2 = new HeroNode(2, "22", "22");
        HeroNode node3 = new HeroNode(3, "33", "33");
        SingleLinkedList list = new SingleLinkedList();
        list.add(node1);
        list.add(node2);
        list.add(node3);

        list.list();
    }
}

class SingleLinkedList {

    private HeroNode head = new HeroNode(0, "", "");

    public void add(HeroNode heroNode) {
        HeroNode temp = this.head;
        while (true) {
            // 判断是否到链表末尾
            if (temp.next == null) {
                break;
            }

            temp = temp.next;
        }

        temp.next = heroNode;
    }

    public void list() {
        if (this.head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = this.head.next;
        while (true) {
            // 判断是否到链表末尾
            if (temp == null) {
                break;
            }

            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode {

    public int no;

    public String name;

    public String nickName;

    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        int nextNo = -1;

        if (this.next != null) {
            nextNo = this.next.no;
        }

        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", next=" + nextNo +
                '}';
    }
}
