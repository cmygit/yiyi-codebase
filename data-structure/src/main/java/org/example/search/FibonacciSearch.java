package org.example.search;

import java.util.Arrays;

/**
 * @Title: 斐波那契查找
 * @Author: cmy
 * @Date: 2021/1/30 16:31
 */
public class FibonacciSearch {

    private static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};

        int index = search(arr, 89);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("index = " + index);
        }
    }

    private static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f;
    }

    /**
     * 斐波那契查找
     *
     * @param arr     待查找数组
     * @param findVal 查找目标值
     * @return 目标值下标
     */
    private static int search(int[] arr, int findVal) {
        int low = 0;
        int high = arr.length - 1;
        // 表示斐波那契分割数值的下标
        int k = 0;
        int mid = 0;
        int[] f = fib();

        while (high > f[k] - 1) {
            k++;
        }

        // f[k] 可能大于 arr 的长度，因此构造一个新的数组，超出 arr 原长度的部分使用最后一位元素填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        while (low <= high) {
            mid = low + f[k - 1] - 1;

            if (findVal < temp[mid]) {
                // 向左递归
                high = mid - 1;
                k--;
            } else if (findVal > temp[mid]) {
                // 向右递归
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }

        return -1;
    }
}
