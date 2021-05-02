package com.gj.routine.lt;

import java.util.Scanner;

/**
 * lt-7.整数反转  //需要判断是否数字大小越界
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 *
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 *
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 *
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 *
 * 提示：
 * -231 <= x <= 231 - 1
 */
public class lt_7 {
    public static int reverse(int x){
        int res = 0;
        while (x!=0){
            int pop = x % 10;
            x = x/10;
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && pop>7))
                return 0;
            if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && pop<-8))
                return 0;
            res = res * 10 + pop;

        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println(reverse(num));
    }
}
