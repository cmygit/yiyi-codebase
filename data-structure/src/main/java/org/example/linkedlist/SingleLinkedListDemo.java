package org.example.linkedlist;

import java.util.Stack;

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

        System.out.println("逆序打印单链表");
        reversePrint(list.getHead());
        System.out.println();

        // 修改节点
        HeroNode newHeroNode1 = new HeroNode(2, "233", "233~~");
        HeroNode newHeroNode2 = new HeroNode(7, "233", "233~~");
        list.update(newHeroNode1);
        list.update(newHeroNode2);

        list.list();
        System.out.println();

        // 查找单链表中的倒数第 k 个节点
        System.out.println("倒数第 4 个节点:" + findLastIndexNode(list.getHead(), 4));
        System.out.println();

        // 求链表长度
        System.out.println("链表长度:" + getLength(list.getHead()));
        System.out.println();

        // 删除节点
        list.delete(0);
        list.delete(6);
        list.delete(2);
        list.delete(4);

        list.list();
        System.out.println();

        // 链表反转
        System.out.println("链表反转");
        reverseList(list.getHead());
        list.list();
        System.out.println();
    }

    /**
     * 逆序打印链表
     *
     * @param head 链表的头节点
     */
    public static void reversePrint(HeroNode head) {
        // 若链表为空，则直接返回
        if (head.next == null) {
            return;
        }

        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;

        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 反转链表
     *
     * @param head 链表的头节点
     */
    public static void reverseList(HeroNode head) {
        // 若链表为空或只有一个节点，则直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }

        // 指向当前节点
        HeroNode cur = head.next;
        // 指向当前节点的下一个节点
        HeroNode next;
        // 反转的链表的头节点
        HeroNode reverseHead = new HeroNode(0, "", "");

        // 遍历原来的链表，每遍历一个节点，将其加入到反转链表的最前端
        while (cur != null) {
            next = cur.next;
            // 将当前节点的下一个节点指向反转链表的第一个节点（不包括头节点）
            cur.next = reverseHead.next;
            // 将头节点指向新的第一个节点
            reverseHead.next = cur;
            // 继续遍历下一个节点
            cur = next;
        }

        // 将 head.next 指向 reverseHead.next，实现单链表的反转
        head.next = reverseHead.next;
    }

    /**
     * 查找单链表中的倒数第 k 个节点
     * 1.求链表长度 length
     * 2.遍历链表，遍历次数为 length - index，指向的节点即为所求节点
     *
     * @param head  链表的头节点
     * @param index k
     * @return 目标节点
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }

        int length = getLength(head);

        if (index <= 0 || index > length) {
            return null;
        }

        HeroNode cur = head.next;

        for (int i = 0; i < length - index; i++) {
            cur = cur.next;
        }

        return cur;
    }

    /**
     * 返回链表的元素个数
     *
     * @param head 链表的头节点
     * @return 链表的元素个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }

        int length = 0;
        HeroNode cur = head.next;

        while (cur != null) {
            length++;
            cur = cur.next;
        }

        return length;
    }
}

class SingleLinkedList {

    private final HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

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
