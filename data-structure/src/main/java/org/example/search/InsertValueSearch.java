package org.example.search;

import java.util.stream.IntStream;

/**
 * @Title: 插值查找，适用于数据量大，且数据分布比较均匀的集合
 * @Author: cmy
 * @Date: 2021/1/29 23:05
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr = IntStream.rangeClosed(1, 100).toArray();
        int index = search(arr, 0, arr.length - 1, 89);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("findVal = " + arr[index] + ", index = " + index);
        }
    }

    /**
     * 插值查找
     *
     * @param arr     有序数组
     * @param left    左端索引
     * @param right   右端索引
     * @param findVal 目标值
     * @return 目标值索引
     */
    private static int search(int[] arr, int left, int right, int findVal) {
        // findVal < arr[0] 和 findVal > arr[arr.length - 1] 条件必须要有
        // 否则求得的 mid 可能会越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }

        // 自适应中值索引
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];

        if (findVal > midVal) {
            // 右递归
            return search(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return search(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
