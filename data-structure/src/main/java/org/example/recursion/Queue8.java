package org.example.recursion;

/**
 * @Title: 八皇后问题
 * @Author: cmy
 * @Date: 2021/1/18 21:53
 */
public class Queue8 {

    final int max = 8;

    final int[] array = new int[max];

    int count = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("解法个数: " + queue8.count);
    }

    private void check(int n) {
        if (n == this.max) {
            // 已找到一种解法
            print();
            return;
        }

        for (int i = 0; i < this.max; i++) {
            // 先把当前皇后放在所在行的第1个位置，依次遍历
            this.array[n] = i;

            // 此时判断第n个皇后是否冲突
            if (this.judge(n)) {
                // 不冲突，继续放置下一个皇后，开始递归
                this.check(n + 1);
            }
            // else {
            //     break;
            // }
            // 如果冲突，则进行下一次遍历，将皇后放在所在行的下一列位置
        }
    }

    /**
     * 放置第n个皇后，检测是否与已摆放的皇后冲突
     *
     * @param n 第n个皇后
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // 1、this.array[i] == this.array[n] 表示是否在同一列
            // 2、Math.abs(n - i) == Math.abs(this.array[n] - this.array[i]) 表示是否在同一斜线
            if (this.array[i] == this.array[n] || Math.abs(n - i) == Math.abs(this.array[n] - this.array[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        this.count++;
        for (int i = 0; i < this.array.length; i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
    }
}
