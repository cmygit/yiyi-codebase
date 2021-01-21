package org.example.sort;

import java.util.Arrays;

/**
 * @Title: 冒泡排序
 * @Author: cmy
 * @Date: 2021/1/21 21:03
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};

        // 辅助变量
        int temp;
        // 冒泡排序的时间复杂度为O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            System.out.println("第" + (i + 1) + "轮排序后的数组");
            System.out.println(Arrays.toString(arr));
        }
    }
}
