package org.example.sort;

import java.util.Arrays;

/**
 * @Title: 归并排序
 * @Author: cmy
 * @Date: 2021/1/26 22:00
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};
        int[] temp = new int[arr.length];

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        sort(arr, 0, arr.length - 1, temp);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 分而治之
     *
     * @param arr   待排序数组
     * @param left  最左端指针
     * @param right 最右端指针
     * @param temp  保存临时序列的数组（与待排序数组长度一致，因为最后一次合并的数组即为排序完成的目标数组）
     */
    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }

        // 分
        // 中间指针
        int mid = (left + right) / 2;
        // 向左递归分解数组
        sort(arr, left, mid, temp);
        // 向右递归分解数组
        sort(arr, mid + 1, right, temp);

        // 治（合并）
        merge(arr, left, mid, right, temp);
    }

    /**
     * 合并方法
     *
     * @param arr   待排序数组
     * @param left  最左端指针，同时表示子数组在原数组中的起始位置索引
     * @param mid   中间指针（指向左端序列的最后一个位置，即右端序列的起始位置的前一个位置）
     * @param right 最右端指针
     * @param temp  保存临时序列的数组（与待排序数组长度一致，因为最后一次合并的数组即为排序完成的目标数组）
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 左边序列的指针
        int l = left;
        // 右边序列的指针
        int r = mid + 1;
        // temp 数组指针
        int t = 0;

        // 按顺序遍历并比较左右两边的序列的元素，依次填充到 temp 数组，直到有一边的数组处理完毕为止
        while (l <= mid && r <= right) {
            // 按照从小到大的顺序排列，哪个元素更小就先进 temp 数组
            if (arr[l] <= arr[r]) {
                // 填充
                temp[t] = arr[l];
                // 移位
                t++;
                l++;
            } else {
                temp[t] = arr[r];
                t++;
                r++;
            }
        }

        // 把剩余的另一边序列的元素依次填充到 temp 数组
        while (l <= mid) {
            // 说明左边序列还有剩余
            temp[t] = arr[l];
            t++;
            l++;
        }

        while (r <= right) {
            // 说明右边序列还有剩余
            temp[t] = arr[r];
            t++;
            r++;
        }

        // 重置辅助指针
        t = 0;
        // 最左端指针，同时表示子数组在原数组中的起始位置索引
        int tempLeft = left;
        // 把 temp 数组的元素填充到 arr 数组，填充到 left 至 right 的部分（子数组位置）
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
