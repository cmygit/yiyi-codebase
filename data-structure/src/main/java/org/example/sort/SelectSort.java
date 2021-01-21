package org.example.sort;

import java.util.Arrays;

/**
 * @Title: 选择排序
 * @Author: cmy
 * @Date: 2021/1/21 22:31
 */
public class SelectSort {

    public static void main(String[] args) {
        int length = 10;
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 999);
        }

        System.out.println("排序前的数组");
        System.out.println(Arrays.toString(arr));

        sort(arr);

        System.out.println("排序后的数组");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     * 时间复杂度：O(n^2)
     *
     * @param arr 排序数组
     */
    public static void sort(int[] arr) {
        // 辅助变量
        int minIndex;
        int min;

        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            min = arr[i];

            for (int j = i; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
