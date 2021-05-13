package com.gj.routine.lt;

import sun.nio.cs.ext.MacHebrew;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @title: 最长有效括号
 * @description: 给你一个只包含 '('和 ')'的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *               示例 1：
 *                  输入：s = "(()"
 *                  输出：2
 *                  解释：最长有效括号子串是 "()"
 *               示例 2：
 *                  输入：s = ")()())"
 *                  输出：4
 *                  解释：最长有效括号子串是 "()()"
 *               示例 3：
 *                  输入：s = ""
 *                  输出：0
 * @author: jguo
 * @date: 2021/5/12
 */
public class lt_32 {
    //动态规划
//    public int longestValidParentheses(String s) {
//        if (s == null || s.length()<2) return 0;
//        int maxLen = 0;
//        int[] dp = new int[s.length()];
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i)==')'){
//                if (s.charAt(i-1)=='('){
//                    dp[i] = (i>=2? dp[i-2]:0) + 2;
//                }else if (i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1) == '('){
//                    dp[i] = dp[i-1] + (i-dp[i-1]-2>=0? dp[i-dp[i-1]-2]:0) + 2;
//                }
//                maxLen = Math.max(maxLen,dp[i]);
//            }else {
//                dp[i] = 0;
//            }
//        }
//        return maxLen;
//    }
    //栈
    public int longestValidParentheses(String s){
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入括号串（只包含'（'和'）'）：");
        String s = in.nextLine();
        lt_32 solution = new lt_32();
        System.out.println(solution.longestValidParentheses(s));
    }

}
