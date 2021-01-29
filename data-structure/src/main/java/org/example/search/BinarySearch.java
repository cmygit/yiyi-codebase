package org.example.search;

/**
 * @Title: 二分查找
 * @Author: cmy
 * @Date: 2021/1/29 22:09
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int index = search(arr, 0, arr.length - 1, 89);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("findVal = " + arr[index] + ", index = " + index);
        }
    }

    /**
     * 二分查找
     *
     * @param arr     有序数组
     * @param left    左端索引
     * @param right   右端索引
     * @param findVal 目标值
     * @return 目标值索引
     */
    private static int search(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
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
