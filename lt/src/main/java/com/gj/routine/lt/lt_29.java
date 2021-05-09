package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 两数相除
 * @description: 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *               返回被除数dividend除以除数divisor得到的商。
 *               整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *               示例1:
 *               输入: dividend = 10, divisor = 3
 *               输出: 3
 *               解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 *               示例2:
 *               输入: dividend = 7, divisor = -3
 *               输出: -2
 *               解释: 7/-3 = truncate(-2.33333..) = -2
 *               提示：被除数和除数均为 32 位有符号整数；除数不为0；假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231− 1]。
 *                    本题中，如果除法结果溢出，则返回 231− 1。
 * @author: jguo
 * @date: 2021/5/9
 */
public class lt_29 {
    //倍增算法
    public int divide(int dividend, int divisor) {
        if (dividend == 0){
            return 0;
        }
        if (divisor == 1) return dividend;
        if (divisor == -1){
            if (dividend > Integer.MIN_VALUE)
                return -dividend;
            else
                return Integer.MAX_VALUE;
        }
        long a = dividend;
        long b = divisor;
        int sign = 1;
        if ((a>0 && b<0) || (a<0 && b>0)){
            sign = -1;
        }
        a = a>0? a:-a;
        b = b>0? b:-b;
        int resCache = divCore(a,b);
        return sign * resCache;

    }
    //TODO:倍增法核心点
    public int divCore(long dividend,long divisor){
        if (dividend<divisor)
            return 0;
        int count = 1;
        long temp = divisor;
        while (temp+temp<=dividend){
            count = count + count;
            temp = temp + temp;
        }
        return count+divCore(dividend-temp,divisor);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入被除数：");
        int dividend = in.nextInt();
        System.out.println("请输入除数：");
        int divisor = in.nextInt();
        lt_29 solution = new lt_29();
        System.out.println(solution.divide(dividend, divisor));
    }
}
