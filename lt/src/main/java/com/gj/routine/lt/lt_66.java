package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 加一
 * @description: 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *               最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *               你可以假设除了整数 0 之外，这个整数不会以零开头。
 *               示例1：
 *               输入：digits = [1,2,3]
 *               输出：[1,2,4]
 *                  解释：输入数组表示数字 123。
 *               示例2：
 *               输入：digits = [4,3,2,1]
 *               输出：[4,3,2,2]
 *                  解释：输入数组表示数字 4321。
 *               示例3：
 *                  输入：digits = [0]
 *                  输出：[1]
 *               提示：
 *                  1 <= digits.length <= 100
 *                  0 <= digits[i] <= 9
 * @author: jguo
 * @date: 2021/7/17
 */
public class lt_66 {

    //自己想复杂了，算法很简练。
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0){
            return new int[0];
        }
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i]%10;
            if (digits[i]!=0){
                return digits;
            }
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] sInput = s.trim().split(",");
        int[] digits = new int[sInput.length];
        System.out.println("输入的数组：");
        for (int i = 0; i < digits.length; i++) {
            digits[i] = Integer.parseInt(sInput[i]);
            System.out.print(digits[i]+"\t");
        }
        System.out.println();
        lt_66 solution = new lt_66();
        int[] results = solution.plusOne(digits);
        System.out.println("输出的数组：");
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i]+"\t");
        }
    }
}
