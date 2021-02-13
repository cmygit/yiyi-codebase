package org.example.tree.bst;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2021/2/13 17:21
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};

        BinarySortTree tree = new BinarySortTree();

        for (int i = 0; i < arr.length; i++) {
            tree.add(new Node(arr[i]));
        }

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
    }
}
