package org.example.sort;

import java.util.Arrays;

/**
 * @Title: 快速排序
 * @Author: cmy
 * @Date: 2021/1/25 22:46
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        sort(arr, 0, arr.length - 1);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序-填数法
     *
     * @param arr   数组
     * @param left  最左端
     * @param right 最右端
     */
    private static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        // 左端指针
        int l = left;
        // 右端指针
        int r = right;
        // 约定最左端值为中轴值，它最终落在的位置，会使得左边元素都小于等于它，右边所有元素都大于等于它。
        int pivot = arr[left];

        // l 和 r 分别从两端开始遍历，当 l == r 时，说明所有元素均被遍历，循环结束
        // 用填数思想理解算法
        while (l < r) {
            // 从右向左查找小于中轴值的元素
            while (l < r && arr[r] >= pivot) {
                // 没找到，指针移位
                r--;
            }

            // 找到了目标值
            if (l < r) {
                // 把小于中轴值的元素都排在中轴值的左边
                // 第一次循环时，由于 arr[l] 的值保存到中轴值 pivot，则 l 位置视为空，可放置元素。
                // 当 arr[r] 元素放置到 arr[l] 后，r 位置视为空，可放置元素。
                arr[l] = arr[r];
                // 放置后，当前下标的元素位置已确认，指针移位
                l++;
            }

            // 从左向右查找大于等于中轴值的元素
            while (l < r && arr[l] < pivot) {
                // 没找到，指针移位
                l++;
            }

            // 找到了目标值
            if (l < r) {
                // 将大于等于中轴值的元素都排在中轴值的右边
                // 根据上面的判断得知，当前 r 位置视为空，可放置元素。
                // 当 arr[l] 元素放置到 arr[r] 后，l 位置视为空，可放置元素，以此类推。
                arr[r] = arr[l];
                // 放置后，当前下标的元素位置已确认，指针移位
                r--;
            }
        }

        // l == r 时，循环结束，只剩下最后一个空位，就是中轴值的位置。
        arr[l] = pivot;

        // 递归调用
        // 以中轴值下标为界划分子数组，然后继续排序
        sort(arr, left, l - 1);
        sort(arr, l + 1, right);
    }
}
