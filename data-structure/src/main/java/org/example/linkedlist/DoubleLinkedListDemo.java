package org.example.linkedlist;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2021/1/4 21:21
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        System.out.println("测试双向链表");
        HeroNode2 node1 = new HeroNode2(1, "1", "11");
        HeroNode2 node2 = new HeroNode2(2, "2", "22");
        HeroNode2 node3 = new HeroNode2(3, "3", "33");
        HeroNode2 node4 = new HeroNode2(4, "4", "44");
        HeroNode2 node5 = new HeroNode2(5, "5", "55");
        DoubleLinkedList list = new DoubleLinkedList();

        // 添加节点
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);

        list.list();
        System.out.println();

        // 修改节点
        HeroNode2 newHeroNode1 = new HeroNode2(2, "233", "233~~");
        HeroNode2 newHeroNode2 = new HeroNode2(7, "233", "233~~");
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

class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return this.head;
    }

    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = this.head;
        while (true) {
            // 判断是否到链表末尾
            if (temp.next == null) {
                break;
            }

            temp = temp.next;
        }

        temp.next = heroNode;
        heroNode.prev = temp;
    }

    public void update(HeroNode2 newHeroNode) {
        if (this.head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = this.head;
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
        HeroNode2 temp = this.head.next;
        boolean isExist = false;

        while (true) {
            // 判断是否到链表末尾
            if (temp == null) {
                break;
            }

            // 判断是否找到了目标位置
            else if (temp.no == no) {
                isExist = true;
                break;
            }

            // 遍历下一个节点
            temp = temp.next;
        }

        // 删除节点
        if (isExist) {
            /*
            * 链表示例：1 >< 2 >< 3 -->> 1 >< 3
            * 删除节点 2，其中节点 2 为 temp 节点
            *
            * temp 节点（节点2）的上一个节点（节点1）的 next，指向 temp 节点的下一个节点（节点3）
            * temp.prev.next = temp.next;
            *
            * temp 节点（节点2）的下一个节点（节点3）的 prev，指向 temp 节点的上一个节点（节点1）
            * temp.next.prev = temp.prev;
            *
            * */
            temp.prev.next = temp.next;
            // 如果是删除最后一个节点，此时 temp.next 为空，则不需要执行这一步
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
        } else {
            System.out.printf("不存在编号为 %d 的节点\n", no);
        }
    }

    public void list() {
        if (this.head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = this.head.next;
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

class HeroNode2 {

    public int no;

    public String name;

    public String nickName;

    public HeroNode2 prev;

    public HeroNode2 next;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        String prevNo = "null";
        String nextNo = "null";

        if (this.prev != null) {
            prevNo = String.valueOf(this.prev.no);
        }

        if (this.next != null) {
            nextNo = String.valueOf(this.next.no);
        }

        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", prev=" + prevNo +
                ", next=" + nextNo +
                '}';
    }
}
