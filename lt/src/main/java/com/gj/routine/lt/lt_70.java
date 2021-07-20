package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 爬楼梯
 * @description: 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
 *               每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *               注意：给定 n 是一个正整数。
 *               示例 1：
 *               输入： 2
 *               输出： 2
 *               解释： 有两种方法可以爬到楼顶。
 *                     1.  1 阶 + 1 阶
 *                     2.  2 阶
 *               示例 2：
 *               输入： 3
 *               输出： 3
 *               解释： 有三种方法可以爬到楼顶。
 *                     1.  1 阶 + 1 阶 + 1 阶
 *                     2.  1 阶 + 2 阶
 *                     3.  2 阶 + 1 阶
 * @author: jguo
 * @date: 2021/7/19
 */
public class lt_70 {

    public int climbStairs(int n) {
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int[] ans = new int[n+1];
        ans[1] = 1;
        ans[2] = 2;
        for (int i = 3; i < n+1; i++) {
            ans[i] = ans[i-1] + ans[i-2];
        }
        return ans[n];
    }
    //网上的滚动数组思想，用三个数来储存数据
//    public int climbStairs(int n) {
//        int p = 0, q = 0, r = 1;
//        for (int i = 1; i <= n; ++i) {
//            p = q;
//            q = r;
//            r = p + q;
//        }
//        return r;
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        lt_70 solution = new lt_70();
        System.out.println(solution.climbStairs(n));
    }
}
