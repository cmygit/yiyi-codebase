package org.example.tree;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2021/2/1 22:28
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        HeroNode root = new HeroNode(1, "宋江");
        tree.setRoot(root);
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        System.out.println("前序遍历");
        tree.preOrder();

        System.out.println("中序遍历");
        tree.inFixOrder();

        System.out.println("后序遍历");
        tree.postOrder();
    }

    private static class BinaryTree {

        private HeroNode root;

        public void setRoot(HeroNode root) {
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

        /**
         * 前序查找
         *
         * @param no 查找目标值
         * @return 目标节点
         */
        public HeroNode preOrderSearch(int no) {
            if (this.root != null) {
                return this.root.preOrderSearch(no);
            } else {
                return null;
            }
        }

        /**
         * 中序查找
         *
         * @param no 查找目标值
         * @return 目标节点
         */
        public HeroNode inFixOrderSearch(int no) {
            if (this.root != null) {
                return this.root.inFixOrderSearch(no);
            } else {
                return null;
            }
        }

        /**
         * 后序查找
         *
         * @param no 查找目标值
         * @return 目标节点
         */
        public HeroNode postOrderSearch(int no) {
            if (this.root != null) {
                return this.root.postOrderSearch(no);
            } else {
                return null;
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

        /**
         * 前序查找
         *
         * @param no 查找目标值
         * @return 目标节点
         */
        public HeroNode preOrderSearch(int no) {
            if (this.no == no) {
                return this;
            }

            HeroNode targetNode = null;

            if (this.left != null) {
                targetNode = this.left.preOrderSearch(no);
            }

            if (targetNode != null) {
                return targetNode;
            }

            if (this.right != null) {
                targetNode = this.right.preOrderSearch(no);
            }

            return targetNode;
        }

        /**
         * 中序查找
         *
         * @param no 查找目标值
         * @return 目标节点
         */
        public HeroNode inFixOrderSearch(int no) {
            HeroNode targetNode = null;

            if (this.left != null) {
                targetNode = this.left.preOrderSearch(no);
            }

            if (targetNode != null) {
                return targetNode;
            }

            if (this.no == no) {
                return this;
            }

            if (this.right != null) {
                targetNode = this.right.preOrderSearch(no);
            }

            return targetNode;
        }

        /**
         * 后序查找
         *
         * @param no 查找目标值
         * @return 目标节点
         */
        public HeroNode postOrderSearch(int no) {
            HeroNode targetNode = null;

            if (this.left != null) {
                targetNode = this.left.preOrderSearch(no);
            }

            if (targetNode != null) {
                return targetNode;
            }

            if (this.right != null) {
                targetNode = this.right.preOrderSearch(no);
            }

            if (targetNode != null) {
                return targetNode;
            }

            if (this.no == no) {
                return this;
            }

            return null;
        }
    }
}
