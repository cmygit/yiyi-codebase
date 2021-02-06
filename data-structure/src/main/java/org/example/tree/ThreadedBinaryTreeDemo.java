package org.example.tree;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2021/2/6 16:33
 */
public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {

    }

    private static class BinaryTree {

        private HeroNode root;

        /**
         * 辅助指针，遍历二叉树时，指向当前结点的上一次遍历的结点
         */
        private HeroNode prev;

        public void setRoot(HeroNode root) {
            this.root = root;
        }

        /**
         * 线索化指定结点
         *
         * @param node 指定结点
         */
        public void threadedNodes(HeroNode node) {
            if (node == null) {
                return;
            }

            // 递归，线索化左子树
            this.threadedNodes(node.getLeft());

            // 线索化当前结点
            if (node.getLeft() == null) {
                // 处理前驱结点的思路：当前结点记录上一个结点
                node.setLeft(this.prev);
                node.setLeftType(1);
            }

            if (this.prev != null && this.prev.getRight() == null) {
                // 处理后继结点的思路：上一个结点记录当前结点
                this.prev.setRight(node);
                this.prev.setRightType(1);
            }

            // 移位
            this.prev = node;

            // 递归，线索化右子树
            this.threadedNodes(node.getRight());
        }

        public void delNode(int no) {
            if (this.root != null) {
                if (this.root.getNo() == no) {
                    this.root = null;
                } else {
                    this.root.delNode(no);
                }
            } else {
                System.out.println("空树，无法删除");
            }
        }
    }

    private static class HeroNode {

        private int no;

        private String name;

        private HeroNode left;

        private HeroNode right;

        /**
         * 0表示指向左子树，1表示指向前驱结点
         */
        private int leftType;

        /**
         * 0表示指向右子树，1表示指向后继结点
         */
        private int rightType;

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

        public int getLeftType() {
            return leftType;
        }

        public void setLeftType(int leftType) {
            this.leftType = leftType;
        }

        public int getRightType() {
            return rightType;
        }

        public void setRightType(int rightType) {
            this.rightType = rightType;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name +
                    "}";
        }

        public void delNode(int no) {
            if (this.left != null && this.left.no == no) {
                this.left = null;
                return;
            }

            if (this.right != null && this.right.no == no) {
                this.right = null;
                return;
            }

            if (this.left != null) {
                this.left.delNode(no);
            }

            if (this.right != null) {
                this.right.delNode(no);
            }
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
