package org.example.sort;

import java.util.Arrays;

/**
 * @Title: 基数排序
 * @Author: cmy
 * @Date: 2021/1/28 22:34
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        sort(arr);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 基数排序
     *
     * @param arr 待排序数组
     */
    private static void sort(int[] arr) {
        // 数组中最大的数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 最大的数的位数
        int maxLen = String.valueOf(max)
                           .length();

        /*
         * 定义一个二维数组，表示10个桶，每个桶的大小与待排序数组大小一致
         * 基数排序是用空间换时间的算法
         * */
        int[][] buckets = new int[10][arr.length];

        // 记录每个桶的元素个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLen; i++, n *= 10) {
            /*
             * 依次计算元素的数值的个位、十位、百位、千位...的位数值，根据位数值将元素放入对应的桶，再进行排序操作
             * 每次循环计算一个位，即第一轮计算个位，第二轮计算百位...
             * */
            for (int j = 0; j < arr.length; j++) {
                // 元素的位数值
                int digitOfElement = arr[j] / n % 10;
                // 放入桶中
                buckets[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            // 辅助下标变量
            int index = 0;
            // 将桶中数据依次取出，即完成一次排序
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 判断桶中是否有数据
                if (bucketElementCounts[k] == 0) {
                    continue;
                }

                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    // 取出元素放入到 arr
                    arr[index] = buckets[k][l];
                    index++;
                }

                // 处理一个桶的数据后，将该桶的个数记录重置
                bucketElementCounts[k] = 0;
            }
        }
    }
}
