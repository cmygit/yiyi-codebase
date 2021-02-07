package org.example.tree;

import java.util.Arrays;

/**
 * @Title: 堆排序
 * @Author: cmy
 * @Date: 2021/2/6 22:49
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {69, 52, 86, 75, 58, 4, 32, 85, 9, 91};

        System.out.println("排序前的数组");
        System.out.println(Arrays.toString(arr));

        sort(arr);

        System.out.println("排序后的数组");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序
     *
     * @param arr 待调整数组
     */
    public static void sort(int[] arr) {
        // 最后一个叶子结点
        int lastNode = arr.length - 1;
        // 最后一个非叶子结点，即最后一个叶子结点的父结点
        int parentNode = (lastNode - 1) / 2;

        // 构建最大堆
        for (int i = parentNode; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        // 冒泡法+迭代调整堆
        for (int i = arr.length - 1; i > 0; i--) {
            // 冒泡
            swap(arr, 0, i);
            // 迭代调整堆
            heapify(arr, 0, i);
        }
    }

    /**
     * 将指定结点对应的子树调整为堆（递归版）
     *
     * @param arr 待调整数组（树）
     * @param k   指定结点
     * @param n   待调整数组元素个数
     */
    public static void heapify(int[] arr, int k, int n) {
        int max = k;
        int c1 = 2 * k + 1;
        int c2 = 2 * k + 2;

        if (c1 < n && arr[c1] > arr[max]) {
            max = c1;
        }

        if (c2 < n && arr[c2] > arr[max]) {
            max = c2;
        }

        if (max != k) {
            // 交换
            swap(arr, k, max);
            // 交换后，可能需要继续调整对应子树，以满足堆的定义
            heapify(arr, max, n);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 将指定结点对应的子树调整为堆（迭代版）
     *
     * @param arr    待调整的数组
     * @param i      非叶子结点在数组中的索引
     * @param length 需要调整元素个数，length在调整过程中会逐渐减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        // 辅助变量
        int temp = arr[i];

        // k = i * 2 + 1 表示 k 是 i 的左子结点
        // k = k * 2 + 1 表示 k 是迭代到下一个左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                // 说明左子结点小于右子结点，将k指向右子结点
                k++;
            }

            if (arr[k] > temp) {
                // 如果子结点大于父结点，则交换
                arr[i] = arr[k];
                // 将i指向k，继续迭代比较
                i = k;
            } else {
                break;
            }
        }

        // 此处i的值有2种可能，
        // 1、上面的循环中，未发生过数据交换，则i保持原值，arr[i] = temp依然成立（相当于没有变动）
        // 2、上面的循环中，发生过数据交换，由于arr[i] = arr[k]，则arr[k]的位置空了出来，
        // 所以将temp填入k的空位，而i最新的值为最后一次循环的k，故arr[i] = temp
        arr[i] = temp;
    }
}
