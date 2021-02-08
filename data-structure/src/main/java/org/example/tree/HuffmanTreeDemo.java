package org.example.tree;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Title: 哈夫曼树
 * @Author: cmy
 * @Date: 2021/2/8 21:37
 */
public class HuffmanTreeDemo {

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);
        preOrder(root);
    }

    public static void preOrder(Node node) {
        node.preOrder();
    }

    /**
     * 构建哈夫曼树
     *
     * @param arr 待调整的数组
     * @return 树的根节点
     */
    public static Node createHuffmanTree(int[] arr) {
        List<Node> nodes = IntStream.of(arr)
                                    .sorted()
                                    .mapToObj(Node::new)
                                    .collect(Collectors.toList());

        while (nodes.size() > 1) {
            // 1、取出权值最小的结点
            Node left = nodes.get(0);
            // 2、取出权值第二小的结点
            Node right = nodes.get(1);
            // 3、构建一颗新的二叉树
            Node parent = new Node(left.getValue() + right.getValue());
            parent.setLeft(left);
            parent.setRight(right);
            // 4、删除已经处理过的结点
            nodes.remove(left);
            nodes.remove(right);
            // 5、将parent重新加入到集合
            nodes.add(parent);

            // 重新排序
            nodes.sort(Comparator.comparingInt(Node::getValue));
        }

        return nodes.get(0);
    }

    private static class Node {

        private int value;

        private Node left;

        private Node right;

        public void preOrder() {
            System.out.println(this);

            if (this.left != null) {
                this.left.preOrder();
            }

            if (this.right != null) {
                this.right.preOrder();
            }
        }

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
