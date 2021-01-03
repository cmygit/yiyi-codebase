package org.example.linkedlist;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2021/1/2 21:55
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "1", "11");
        HeroNode node2 = new HeroNode(2, "2", "22");
        HeroNode node3 = new HeroNode(3, "3", "33");
        HeroNode node4 = new HeroNode(4, "4", "44");
        HeroNode node5 = new HeroNode(5, "5", "55");
        SingleLinkedList list = new SingleLinkedList();

        // 添加节点
        // list.add(node1);
        // list.add(node2);
        // list.add(node3);
        // list.add(node4);
        // list.add(node5);

        // 按顺序添加节点
        list.addByOrder(node4);
        list.addByOrder(node2);
        list.addByOrder(node1);
        list.addByOrder(node5);
        list.addByOrder(node3);
        list.addByOrder(node2);
        list.addByOrder(node4);

        list.list();
        System.out.println();

        // 修改节点
        HeroNode newHeroNode1 = new HeroNode(2, "233", "233~~");
        HeroNode newHeroNode2 = new HeroNode(7, "233", "233~~");
        list.update(newHeroNode1);
        list.update(newHeroNode2);

        list.list();
        System.out.println();

        // 删除节点
        list.delete(0);
        list.delete(6);
        list.delete(2);
        list.delete(4);

        list.list();
        System.out.println();
    }
}

class SingleLinkedList {

    private final HeroNode head = new HeroNode(0, "", "");

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

    public void addByOrder(HeroNode heroNode) {
        // 辅助变量 temp，指向要添加的位置的前一个的节点
        HeroNode temp = this.head;
        boolean isExist = false;

        while (true) {
            // 判断是否到链表末尾
            if (temp.next == null) {
                break;
            }

            // 判断是否找到了目标位置
            if (temp.next.no > heroNode.no) {
                break;
            }
            // 判断目标位置已存在元素
            else if (temp.next.no == heroNode.no) {
                isExist = true;
                break;
            }

            // 遍历下一个节点
            temp = temp.next;
        }

        if (isExist) {
            System.out.printf("编号 %d 已存在元素，不能继续添加\n", heroNode.no);
        }
        // 插入链表
        else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void update(HeroNode newHeroNode) {
        if (this.head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = this.head;
        boolean isExist = false;

        while (true) {
            // 判断是否到链表末尾
            if (temp == null) {
                break;
            }

            if (temp.no == newHeroNode.no) {
                isExist = true;
                break;
            }

            temp = temp.next;
        }

        if (isExist) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.printf("不存在编号为 %d 的节点\n", newHeroNode.no);
        }
    }

    public void delete(int no) {
        // 辅助变量 temp，指向要添加的位置的前一个的节点
        HeroNode temp = this.head;
        boolean isExist = false;

        while (true) {
            // 判断是否到链表末尾
            if (temp.next == null) {
                break;
            }

            // 判断是否找到了目标位置
            else if (temp.next.no == no) {
                isExist = true;
                break;
            }

            // 遍历下一个节点
            temp = temp.next;
        }

        // 删除节点
        if (isExist) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("不存在编号为 %d 的节点\n", no);
        }
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
        String nextNo = "null";

        if (this.next != null) {
            nextNo = String.valueOf(this.next.no);
        }

        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", next=" + nextNo +
                '}';
    }
}
