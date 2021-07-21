package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 编辑距离
 * @description: 给你两个单词word1 和word2，请你计算出将word1转换成word2 所使用的最少操作数。
 *               你可以对一个单词进行如下三种操作：
 *                  插入一个字符
 *                  删除一个字符
 *                  替换一个字符
 *               示例1：
 *                  输入：word1 = "horse", word2 = "ros"
 *                  输出：3
 *                  解释：
 *                  horse -> rorse (将 'h' 替换为 'r')
 *                  rorse -> rose (删除 'r')
 *                  rose -> ros (删除 'e')
 *               示例2：
 *                  输入：word1 = "intention", word2 = "execution"
 *                  输出：5
 *                  解释：
 *                  intention -> inention (删除 't')
 *                  inention -> enention (将 'i' 替换为 'e')
 *                  enention -> exention (将 'n' 替换为 'x')
 *                  exention -> exection (将 'n' 替换为 'c')
 *                  exection -> execution (插入 'u')
 *               提示：
 *                  0 <= word1.length, word2.length <= 500
 *                  word1 和 word2 由小写英文字母组成
 * @author: jguo
 * @date: 2021/7/21
 */
public class lt_72 {

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        //判断输入错误的情况
        if (n*m == 0){
            return m + n;
        }
        //dp数组
        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i < n+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < m+1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                int l = dp[i-1][j] + 1;
                int d = dp[i][j-1] + 1;
                int l_d = dp[i-1][j-1];
                if (word1.charAt(i-1) != word2.charAt(j-1)){
                    l_d += 1;
                }
                dp[i][j] = Math.min(l,Math.min(d,l_d));
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("给你两个单词word1和word2，请你计算出将word1转换成word2所使用的最少操作数。");
        System.out.println("输入word1：");
        String word1 = in.nextLine();
        System.out.println("输入word2：");
        String word2 = in.nextLine();
        lt_72 solution = new lt_72();
        System.out.println("最少操作数：");
        System.out.println(solution.minDistance(word1, word2));
    }
}
