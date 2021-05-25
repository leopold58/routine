package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 通配符匹配
 * @description: 给定一个字符串(s) 和一个字符模式(p) ，实现一个支持'?'和'*'的通配符匹配。
 *               '?' 可以匹配任何单个字符。
 *               '*' 可以匹配任意字符串（包括空字符串）。
 *               两个字符串完全匹配才算匹配成功。
 *               说明:
 *                  s可能为空，且只包含从a-z的小写字母。
 *                  p可能为空，且只包含从a-z的小写字母，以及字符?和*。
 *               示例1:
 *                  输入:
 *                  s = "aa"
 *                  p = "a"
 *                  输出: false
 *                  解释: "a" 无法匹配 "aa" 整个字符串。
 * @author: jguo
 * @date: 2021/5/21
 */
public class lt_44 {

    public boolean isMatch(String s, String p) {
        int len1 = p.length(), len2 = s.length();
        boolean[][] dp = new boolean[len1 + 1] [len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            if (p.charAt(i - 1) != '*') {
                break;
            }
            dp[i][0] = true;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String p = in.nextLine();
        lt_44 solution = new lt_44();
        System.out.println(solution.isMatch(s, p));

    }
}
