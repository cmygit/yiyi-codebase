package org.example.search;

/**
 * @Title: 线性查找
 * @Author: cmy
 * @Date: 2021/1/29 21:39
 */
public class SeqSearch {

    public static void main(String[] args) {
        int[] arr = {1, 9, 11, -1, 34, 89};
        int index = search(arr, 11);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("index = " + index);
        }
    }

    public static int search(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }

        return -1;
    }
}
