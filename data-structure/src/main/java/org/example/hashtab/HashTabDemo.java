package org.example.hashtab;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2021/1/30 18:55
 */
public class HashTabDemo {

    public static void main(String[] args) {

    }

    private class HashTab {

        private final int size;

        private EmpLinkedList[] empLinkedLists;

        public HashTab(int size) {
            this.size = size;
            this.empLinkedLists = new EmpLinkedList[size];
        }

        public void add(Emp emp) {
            int no = this.hashFun(emp.id);
            this.empLinkedLists[no].add(emp);
        }

        public void list() {
            for (int i = 0; i < this.size; i++) {
                this.empLinkedLists[i].list();
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

    private class Emp {

        public int id;

        public String name;

        public Emp next;

        public Emp(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    private class EmpLinkedList {

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

        public void list() {
            if (this.head == null) {
                System.out.println("当前链表为空");
                return;
            }

            System.out.println("当前链表信息为：");

            Emp cur = this.head;
            while (true) {
                System.out.printf("id=%d, name=%s\t", cur.id, cur.name);

                if (cur.next == null) {
                    break;
                }

                cur = cur.next;
            }

            System.out.println();
        }
    }
}
