package org.example.huffmancode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2021/2/10 16:26
 */
public class HuffmanCodeDemo {

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();

        List<Node> nodes = getNodes(contentBytes);

        System.out.println(nodes);

        Node root = createHuffmanTree(nodes);
        preOrder(root);
    }

    public static void preOrder(Node node) {
        node.preOrder();
    }

    /**
     * 构建结点集合
     *
     * @param bytes 内容数组
     * @return 结点集合
     */
    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();

        List<Byte> byteList = new ArrayList<>();
        for (byte b : bytes) {
            byteList.add(b);
        }

        // 统计字符出现次数，分组
        Map<Byte, Long> counts = byteList.stream()
                                         .collect(Collectors.groupingBy(
                                                 Function.identity(), Collectors.counting()
                                         ));
        // 构建结点集合
        counts.forEach((k, v) -> nodes.add(new Node(k, Math.toIntExact(v))));

        return nodes;
    }

    /**
     * 构建哈夫曼树
     *
     * @param nodes 待调整的结点集合
     * @return 树的根节点
     */
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            // 排序
            nodes.sort(Comparator.comparingInt(Node::getWeight));

            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parentNode = new Node(null, leftNode.getWeight() + rightNode.getWeight());

            parentNode.setLeft(leftNode);
            parentNode.setRight(rightNode);

            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parentNode);
        }

        return nodes.get(0);
    }

    private static class Node {

        /**
         * 存放数据本身
         */
        private Byte data;

        /**
         * 权值
         */
        private int weight;

        private Node left;

        private Node right;

        public Node(Byte data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        public Byte getData() {
            return data;
        }

        public void setData(Byte data) {
            this.data = data;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
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
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }

        public void preOrder() {
            System.out.println(this);

            if (this.left != null) {
                this.left.preOrder();
            }

            if (this.right != null) {
                this.right.preOrder();
            }
        }
    }
}


