package org.example.sort;

import java.util.Arrays;

/**
 * @Title: 希尔排序
 * @Author: cmy
 * @Date: 2021/1/24 22:28
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        // sort(arr);
        sort2(arr);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔排序-交换式
     * 效率相对更高
     *
     * @param arr 排序数组
     */
    public static void sort(int[] arr) {
        int temp;

        // 循环分组交换，gap为间隔，同一间隔的元素为一组。
        // 当gap为1时，则整个数组元素为一组，完成最后一次排序，结束循环
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 分组循环
            for (int i = gap; i < arr.length; i++) {
                // 单组循环
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    /**
     * 希尔排序-移位式
     * 效率相对更高
     *
     * @param arr 排序数组
     */
    public static void sort2(int[] arr) {
        int insertVal;
        int insertIndex;

        // 循环分组交换，gap为间隔，同一间隔的元素为一组。
        // 当gap为1时，则整个数组元素为一组，完成最后一次排序，结束循环
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 分组循环
            for (int i = gap; i < arr.length; i++) {
                // 插入排序
                insertVal = arr[i];
                insertIndex = i;

                while (insertIndex - gap >= 0 && insertVal < arr[insertIndex - gap]) {
                    // 向前移位，交换数据，继续比较，直到找到最终位置
                    arr[insertIndex] = arr[insertIndex - gap];
                    insertIndex -= gap;
                }

                if (insertIndex != i) {
                    arr[insertIndex] = insertVal;
                }
            }
        }
    }
}
