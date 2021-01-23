package org.example.sort;

import java.util.Arrays;

/**
 * @Title: 插入排序
 * @Author: cmy
 * @Date: 2021/1/23 23:08
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        sort(arr);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // 辅助变量
        int insertVal;
        int insertIndex;

        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;

            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
}
