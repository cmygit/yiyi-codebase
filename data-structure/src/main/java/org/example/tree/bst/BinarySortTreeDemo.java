package org.example.tree.bst;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2021/2/13 17:21
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9,2};

        BinarySortTree tree = new BinarySortTree();

        for (int value : arr) {
            tree.add(new Node(value));
        }

        System.out.println("中序遍历：");
        tree.infixOrder();

        System.out.println("删除叶子结点~");
        tree.delNode(2);

        System.out.println("中序遍历：");
        tree.infixOrder();
    }

    private static class BinarySortTree {

        private Node root;

        public void add(Node node) {
            if (this.root == null) {
                this.root = node;
            } else {
                this.root.add(node);
            }
        }

        public void infixOrder() {
            if (this.root == null) {
                System.out.println("树为空，无法遍历");
                return;
            }

            this.root.infixOrder();
        }

        public Node search(int value) {
            if (this.root == null) {
                System.out.println("树为空，无法查找");
                return null;
            }

            return this.root.search(value);
        }

        public Node searchParent(int value) {
            if (this.root == null) {
                System.out.println("树为空，无法查找");
                return null;
            }

            return this.root.searchParent(value);
        }

        /**
         * 删除结点
         *
         * @param value 目标值
         */
        public void delNode(int value) {
            if (this.root == null) {
                System.out.println("树为空，无法删除");
                return;
            }

            Node targetNode = this.search(value);

            if (targetNode == null) {
                return;
            }

            // 如果二叉树只有一个结点
            if (this.root.left == null && this.root.right == null) {
                this.root = null;
                return;
            }

            Node parentNode = this.searchParent(value);

            // 如果删除的结点是叶子结点
            if (targetNode.left == null && targetNode.right == null) {
                if (parentNode.left != null && parentNode.left.value == value) {
                    parentNode.left = null;
                } else if (parentNode.right != null && parentNode.right.value == value) {
                    parentNode.right = null;
                }
            }
        }
    }

    private static class Node {

        int value;

        Node left;

        Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        public void add(Node node) {
            if (node == null) {
                return;
            }

            if (node.value < this.value) {
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.add(node);
                }
            } else {
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.add(node);
                }
            }
        }

        public void infixOrder() {
            if (this.left != null) {
                this.left.infixOrder();
            }

            System.out.println(this);

            if (this.right != null) {
                this.right.infixOrder();
            }
        }

        /**
         * 查找目标结点
         *
         * @param value 目标值
         * @return 目标结点
         */
        public Node search(int value) {
            if (this.value > value) {
                if (this.left == null) {
                    return null;
                }

                return this.left.search(value);
            } else if (this.value < value) {
                if (this.right == null) {
                    return null;
                }

                return this.right.search(value);
            } else {
                return this;
            }
        }

        /**
         * 查找目标结点的父结点
         *
         * @param value 目标值
         * @return 父结点
         */
        public Node searchParent(int value) {
            if ((this.left != null && this.left.value == value)
                    || (this.right != null && this.right.value == value)) {
                return this;
            } else {
                if (this.value > value && this.left != null) {
                    return this.left.searchParent(value);
                } else if (this.value <= value && this.right != null) {
                    return this.right.searchParent(value);
                } else {
                    return null;
                }
            }
        }
    }
}
