package org.example.tree;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2021/2/6 22:49
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
    }

    public static void sort(int[] arr) {

    }

    /**
     * 将指定非叶子结点的数调整为大顶堆
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
