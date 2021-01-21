package org.example.sort;

import java.util.Arrays;

/**
 * @Title: 冒泡排序
 * @Author: cmy
 * @Date: 2021/1/21 21:03
 */
public class BubbleSort {

    public static void main(String[] args) {
        // int[] arr = {3, 9, -1, 10, -6};
        int length = 20;
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 8000);
        }

        System.out.println("排序前的数组");
        System.out.println(Arrays.toString(arr));

        sort(arr);

        System.out.println("排序后的数组");
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // 辅助变量
        int temp;
        // 是否发生过交换
        boolean exFlag = false;

        // 冒泡排序的时间复杂度为O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    exFlag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if (!exFlag) {
                // 若这一轮排序中，未发生过交换，表示数组已经有序，无需继续循环
                break;
            } else {
                // 重置标识
                exFlag = false;
            }
        }
    }
}
