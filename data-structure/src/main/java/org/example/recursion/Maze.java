package org.example.recursion;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2021/1/17 17:14
 */
public class Maze {

    public static void main(String[] args) {
        // 创建二维数组，模拟迷宫,8 * 7
        int[][] map = new int[8][7];
        // 使用1表示墙
        // 上下两边全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        // 左右两边全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        // 设置墙
        map[3][1] = 1;
        map[3][2] = 1;
        // 设置死胡同
        // map[1][2] = 1;
        // map[2][2] = 1;

        // 输出地图
        System.out.println("约定规则如下：");
        System.out.println("起点为（1，1），终点为（6，5）。");
        System.out.println("1表示墙，0表示可走的路，2表示正确的路径，3表示错误的路径。");
        System.out.println("初始化迷宫：");
        showMap(map);

        // 迷宫寻路
        boolean flag = setWay(map, 1, 1);
        if (flag) {
            System.out.println("迷宫寻路成功");
        } else {
            System.out.println("迷宫寻路失败");
        }
        showMap(map);
    }

    /**
     * 输出迷宫的情况
     *
     * @param map 迷宫
     */
    public static void showMap(int[][] map) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 设置迷宫路径（走法）
     * <p>
     * 递归寻路
     * <p>
     * 约定规则如下：
     * 起点为（1，1），终点为（6，5）。
     * 1表示墙，0表示可走的路，2表示走过的正确的路径，3表示走过的错误的路径。
     * 迷宫走法策略：下->右->上->左
     *
     * @param map 迷宫
     * @param i   当前位置坐标
     * @param j   当前位置坐标
     * @return 如果找到通路，返回true，否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            // 找到通路
            return true;
        } else {
            if (map[i][j] == 0) {
                // 按照 下->右->上->左 的策略走
                // 假定当前位置可通
                map[i][j] = 2;
                // 递归寻路
                if (setWay(map, i + 1, j)) {
                    // 向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    // 向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    // 向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    // 向左走
                    return true;
                } else {
                    // 此路不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                // map[i][j] != 0，可能是1，2，3
                // 其中，1表示墙，不能通行，2和3表示已经走过，不需要再走
                return false;
            }
        }
    }
}
