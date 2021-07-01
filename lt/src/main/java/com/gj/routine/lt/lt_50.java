package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title:  Pow(x, n)
 * @description: 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 *                示例 1：
 *                 输入：x = 2.00000, n = 10
 *                 输出：1024.00000
 *                示例 2：
 *                 输入：x = 2.10000, n = 3
 *                 输出：9.26100
 *                示例 3：
 *                 输入：x = 2.00000, n = -2
 *                 输出：0.25000
 *                 解释：2-2 = 1/22 = 1/4 = 0.25
 *                提示：
 *                 -100.0 <x< 100.0
 *                 -231<= n <=231-1
 *                 -104 <= xn <= 104
 * @author: jguo
 * @date: 2021/7/1
 */
public class lt_50 {

    //快速幂 + 递归
//    public double myPow(double x, int n) {
//        long N = n;
//        return N >= 0? quickMul(x,N) : 1.0/quickMul(x,-N);
//    }
//    public double quickMul(double x, long N){
//        if (N ==0)
//            return 1.0;
//        double y = quickMul(x,N/2);
//        return N%2 == 0? y*y:y*y*x;
//    }

    //快速幂 + 迭代
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0? quickMul(x,N) : 1.0/quickMul(x,-N);
    }
    public double quickMul(double x, long N){
        double res = 1.0;
        double ans = x;
        while (N>0){
            if (N % 2 == 1){
                res *= ans;
            }
            ans *= ans;
            N /=2;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入底数，即double值：");
        double x = in.nextDouble();
        System.out.println("请输入指数，即int值：");
        int n = in.nextInt();
        lt_50 solution = new lt_50();
        double res = solution.myPow(x, n);
        System.out.println("输出的pow（x,n）的结果：");
        System.out.println(res);
    }
}
