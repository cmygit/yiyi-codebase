package org.example;

import java.util.Arrays;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/8/23 20:35
 */
public class Test {

    public static void main(String[] args) {
        String[] arr = new String[]{"1", "2", "3"};
        String result = Arrays.toString(arr);
        result = result.replaceAll("[\\[\\]]", "").replaceAll("\\s", "");
        System.out.println(result);
    }
}
