package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 不同路径
 * @description: 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 *               机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *               问总共有多少条不同的路径？
 *               输入：m = 3, n = 7
 *               输出：28
 *               输入：m = 3, n = 2
 *               输出：3
 *                  解释：
 *                  从左上角开始，总共有 3 条路径可以到达右下角。
 *                  1. 向右 -> 向下 -> 向下
 *                  2. 向下 -> 向下 -> 向右
 *                  3. 向下 -> 向右 -> 向下
 *               提示：
 *                  1 <= m, n <= 100
 *                  题目数据保证答案小于等于 2 * 109
 * @author: jguo
 * @date: 2021/7/16
 */
public class lt_62 {

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0){
            return -1;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("输入m:");
        int m = in.nextInt();
        System.out.print("输入n:");
        int n = in.nextInt();
        lt_62 solution = new lt_62();
        System.out.println("问总共有多少条不同的路径？");
        System.out.println(solution.uniquePaths(m, n));
    }
}
