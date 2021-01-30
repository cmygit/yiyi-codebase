package org.example.hashtab;

import java.util.Scanner;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2021/1/30 18:55
 */
public class HashTabDemo {

    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);

        String key;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add(a): 添加雇员");
            System.out.println("list(l): 显示雇员");
            System.out.println("find(f): 查找雇员");
            System.out.println("exit(e): 退出系统");

            key = scanner.next();

            switch (key) {
                case "a":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "l":
                    hashTab.list();
                    break;
                case "f":
                    System.out.println("输入id");
                    int findId = scanner.nextInt();
                    hashTab.findEmpById(findId);
                    break;
                case "e":
                    scanner.close();
                    return;
                default:
                    break;
            }
        }
    }

    private static class HashTab {

        private final int size;

        private EmpLinkedList[] empLinkedLists;

        public HashTab(int size) {
            this.size = size;
            this.empLinkedLists = new EmpLinkedList[size];
            for (int i = 0; i < this.size; i++) {
                this.empLinkedLists[i] = new EmpLinkedList();
            }
        }

        public void add(Emp emp) {
            int no = this.hashFun(emp.id);
            this.empLinkedLists[no].add(emp);
        }

        public void list() {
            for (int i = 0; i < this.size; i++) {
                this.empLinkedLists[i].list(i);
            }
        }

        public void findEmpById(int id) {
            int no = this.hashFun(id);
            Emp emp = this.empLinkedLists[no].findEmpById(id);
            if (emp == null) {
                System.out.println("在哈希表中没有找到目标数据");
            } else {
                System.out.printf("在链表[%d]中找到雇员 id=%d, name=%s\n", no, emp.id, emp.name);
            }
        }

        /**
         * 散列函数
         *
         * @param id id
         * @return 哈希编码
         */
        public int hashFun(int id) {
            return id % this.size;
        }
    }

    private static class Emp {

        public int id;

        public String name;

        public Emp next;

        public Emp(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    private static class EmpLinkedList {

        private Emp head;

        public void add(Emp emp) {
            if (this.head == null) {
                this.head = emp;
                return;
            }

            Emp cur = this.head;
            while (true) {
                if (cur.next == null) {
                    break;
                }

                cur = cur.next;
            }

            cur.next = emp;
        }

        public void list(int index) {
            if (this.head == null) {
                System.out.println("当前链表为空");
                return;
            }

            System.out.printf("链表[%d]信息为：", index);

            Emp cur = this.head;
            while (true) {
                System.out.printf("=> id=%d, name=%s ", cur.id, cur.name);

                if (cur.next == null) {
                    break;
                }

                cur = cur.next;
            }

            System.out.println();
        }

        public Emp findEmpById(int id) {
            if (this.head == null) {
                System.out.println("链表为空");
                return null;
            }

            Emp cur = this.head;
            while (true) {
                if (cur.id == id) {
                    break;
                }

                if (cur.next == null) {
                    cur = null;
                    break;
                }

                cur = cur.next;
            }

            return cur;
        }
    }
}
