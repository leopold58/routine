package com.gj.routine.lt;

import java.util.Scanner;

/**
 * lt-9.回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左到右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class lt_9 {
    public boolean isPalindrome(int x){
        if (x < 0 || x!=0 && x%10 == 0) return false;   //考虑0值的时候也是回文的。
        int num = 0;
        while (num<x){
            int temp = x % 10;
            x = x/10;
            num = num * 10 + temp;
        }
        if (num == x || x == num/10){return true;}
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        lt_9 solution = new lt_9();
        int number = in.nextInt();
        System.out.println(solution.isPalindrome(number));
    }

}
