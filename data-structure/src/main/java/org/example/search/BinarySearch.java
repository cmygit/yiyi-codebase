package org.example.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: 二分查找
 * @Author: cmy
 * @Date: 2021/1/29 22:09
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1000, 1234};
        int index = search(arr, 0, arr.length - 1, 1000);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("findVal = " + arr[index] + ", index = " + index);
        }

        List<Integer> list = search2(arr, 0, arr.length - 1, 1000);
        if (list == null) {
            System.out.println("没有找到");
        } else {
            System.out.println("findVal = " + arr[index] + ", index = " + list);
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

    /**
     * 二分查找
     * 查找所有符合目标的值
     *
     * @param arr     有序数组
     * @param left    左端索引
     * @param right   右端索引
     * @param findVal 目标值
     * @return 目标值索引集合
     */
    private static List<Integer> search2(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            return search2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return search2(arr, left, mid - 1, findVal);
        } else {
            // 找到目标值
            // 因为数组是有序的，如果存在多个元素等于目标值，这些元素都排在一起。
            List<Integer> list = new ArrayList<>();

            // 向左扫描，把与目标值相等的其他元素下表也添加到集合中
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }

                list.add(temp);
                temp--;
            }

            list.add(mid);

            // 向右扫描
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }

                list.add(temp);
                temp++;
            }

            return list;
        }
    }
}
