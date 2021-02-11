package org.example.huffmancode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2021/2/10 16:26
 */
public class HuffmanCodeDemo {

    private static final Map<Byte, String> HUFFMAN_CODES = new HashMap<>();

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println("contentBytes = " + Arrays.toString(contentBytes));

        byte[] zipBytes = huffmanZip(contentBytes);
        System.out.println("zipBytes = " + Arrays.toString(zipBytes));

        // System.out.println("原始内容：" + content);
        // System.out.println("原始的字节数组：" + Arrays.toString(contentBytes));
        //
        // List<Node> nodes = getNodes(contentBytes);
        // System.out.println("结点集合：" + nodes);
        //
        // Node root = createHuffmanTree(nodes);
        //
        // System.out.println("前序遍历夫曼树");
        // preOrder(root);
        //
        // Map<Byte, String> codes = getCodes(root);
        // System.out.println("生成哈夫曼编码表：" + codes);
        //
        // byte[] huffmanCodeBytes = zip(contentBytes, HUFFMAN_CODES);
        // System.out.println("压缩后的字节数组：" + Arrays.toString(huffmanCodeBytes));
    }

    /**
     * 哈夫曼编码压缩字节数组
     *
     * @param sourceBytes 原数组
     * @return 压缩后的数组
     */
    private static byte[] huffmanZip(byte[] sourceBytes) {
        // 构建哈夫曼树结点
        List<Node> nodes = getNodes(sourceBytes);
        // 创建哈夫曼树
        Node root = createHuffmanTree(nodes);
        // 生成哈夫曼编码表
        Map<Byte, String> huffmanCodes = getCodes(root);
        // 压缩数据
        byte[] zipBytes = zip(sourceBytes, huffmanCodes);

        return zipBytes;
    }

    /**
     * 压缩
     *
     * @param bytes        原始字符串
     * @param huffmanCodes 编码表
     * @return 压缩后的字节数组
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder zipStr = new StringBuilder();

        for (byte b : bytes) {
            zipStr.append(huffmanCodes.get(b));
        }

        int len = zipStr.length() / 8;
        if (zipStr.length() % 8 != 0) {
            len++;
        }

        byte[] huffmanCodeBytes = new byte[len];
        // 记录遍历到第几个byte
        int index = 0;
        // 每8位对应一个byte，所以迭代的步长为8
        for (int i = 0; i < zipStr.length(); i += 8) {
            String byteStr;
            // 最后一次循环不足8位的部分
            if (i + 8 > zipStr.length()) {
                byteStr = zipStr.substring(i);
            } else {
                byteStr = zipStr.substring(i, i + 8);
            }

            // 编码转字节
            huffmanCodeBytes[index] = (byte) Integer.parseInt(byteStr, 2);
            index++;
        }

        return huffmanCodeBytes;
    }

    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }

        getCodes(root, "", new StringBuilder());

        return HUFFMAN_CODES;
    }

    /**
     * 构建哈夫曼编码表
     *
     * @param node      结点
     * @param direction 路径方向 左子结点为0，右子结点为1
     * @param codeStr   编码
     */
    private static void getCodes(Node node, String direction, StringBuilder codeStr) {
        // 拷贝当前编码
        StringBuilder curCodeStr = new StringBuilder(codeStr);
        // 连接路径方向
        curCodeStr.append(direction);

        if (node != null) {
            // 非叶子结点
            if (node.getData() == null) {
                // 向左递归
                getCodes(node.left, "0", curCodeStr);
                // 向右递归
                getCodes(node.right, "1", curCodeStr);
            }
            // 叶子结点
            else {
                // 添加编码
                HUFFMAN_CODES.put(node.getData(), curCodeStr.toString());
            }
        }
    }

    private static void preOrder(Node node) {
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


