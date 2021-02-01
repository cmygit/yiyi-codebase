package org.example.tree;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2021/2/1 22:28
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {

    }

    private static class BinaryTree {

        private HeroNode root;

        public BinaryTree(HeroNode root) {
            this.root = root;
        }

        /**
         * 前序遍历
         */
        public void preOrder() {
            if (this.root != null) {
                this.root.preOrder();
            } else {
                System.out.println("二叉树为空~");
            }
        }

        /**
         * 中序遍历
         */
        public void inFixOrder() {
            if (this.root != null) {
                this.root.inFixOrder();
            } else {
                System.out.println("二叉树为空~");
            }
        }

        /**
         * 后序遍历
         */
        public void postOrder() {
            if (this.root != null) {
                this.root.postOrder();
            } else {
                System.out.println("二叉树为空~");
            }
        }
    }

    private static class HeroNode {

        private int no;

        private String name;

        private HeroNode left;

        private HeroNode right;

        public HeroNode(int no, String name) {
            this.no = no;
            this.name = name;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public HeroNode getLeft() {
            return left;
        }

        public void setLeft(HeroNode left) {
            this.left = left;
        }

        public HeroNode getRight() {
            return right;
        }

        public void setRight(HeroNode right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name +
                    "}";
        }

        /**
         * 前序遍历
         */
        public void preOrder() {
            // 输出父节点
            System.out.println(this);

            if (this.left != null) {
                // 递归，遍历左子树
                this.left.preOrder();
            }

            if (this.right != null) {
                // 递归，遍历右子树
                this.right.preOrder();
            }
        }

        /**
         * 中序遍历
         */
        public void inFixOrder() {
            if (this.left != null) {
                // 递归，遍历左子树
                this.left.inFixOrder();
            }

            // 输出父节点
            System.out.println(this);

            if (this.right != null) {
                // 递归，遍历右子树
                this.right.inFixOrder();
            }
        }

        /**
         * 后序遍历
         */
        public void postOrder() {
            if (this.left != null) {
                // 递归，遍历左子树
                this.left.postOrder();
            }

            if (this.right != null) {
                // 递归，遍历右子树
                this.right.postOrder();
            }

            // 输出父节点
            System.out.println(this);
        }
    }
}
