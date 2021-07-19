package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: x 的平方根
 * @description: 实现int sqrt(int x)函数。
 *               计算并返回x的平方根，其中x 是非负整数。
 *               由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *               示例 1:
 *                  输入: 4
 *                  输出: 2
 *               示例 2:
 *                  输入: 8
 *                  输出: 2
 *                  说明: 8 的平方根是 2.82842...,
 *                       由于返回类型是整数，小数部分将被舍去。
 * @author: jguo
 * @date: 2021/7/18
 */
public class lt_69 {

    //二分法
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("计算x的平方根，请输入x：");
        int x = in.nextInt();
        lt_69 solution = new lt_69();
        System.out.println(solution.mySqrt(x));
    }
}
