package com.gj.routine.lt;

import java.util.Scanner;

/**
 * lt-5.最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 *
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 */
public class lt_5 {
    public static String longestPalindrome(String s){
        if (s.length()<2){
            return s;
        }
        int len = s.length();
        int begin = 0;
        int maxlen = 1;
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i]!=charArray[j]){
                    dp[i][j] = false;
                }
                else {
                    if (j-i<3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && j-i+1 > maxlen){
                    maxlen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = longestPalindrome(s);
        System.out.println(result);
    }
}
