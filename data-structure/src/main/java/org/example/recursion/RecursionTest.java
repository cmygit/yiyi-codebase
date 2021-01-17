package org.example.recursion;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2021/1/17 13:41
 */
public class RecursionTest {

    public static void main(String[] args) {
        // test(10);
        System.out.println("res:" + factorial(4));
    }

    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }

        System.out.println("n=" + n);
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}
