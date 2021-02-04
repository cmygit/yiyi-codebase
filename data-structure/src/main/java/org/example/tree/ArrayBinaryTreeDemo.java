package org.example.tree;

/**
 * @Title: 顺序二叉树
 * @Author: cmy
 * @Date: 2021/2/4 21:56
 */
public class ArrayBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        ArrayBinaryTree tree = new ArrayBinaryTree(arr);
        tree.preOrder();
    }

    static class ArrayBinaryTree {

        private int[] arr;

        public ArrayBinaryTree(int[] arr) {
            this.arr = arr;
        }

        public void preOrder() {
            this.preOrder(0);
        }

        public void preOrder(int index) {
            if (this.arr == null || this.arr.length == 0) {
                System.out.println("数组为空，不能遍历");
            }

            // 输出当前元素
            System.out.println(this.arr[index]);

            // 向左递归遍历
            if ((index * 2 + 1) < this.arr.length) {
                this.preOrder(index * 2 + 1);
            }

            // 向右递归遍历
            if ((index * 2 + 2) < this.arr.length) {
                this.preOrder(index * 2 + 2);
            }
        }
    }
}
