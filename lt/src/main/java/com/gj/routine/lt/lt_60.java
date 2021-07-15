package com.gj.routine.lt;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @title: 排列序列
 * @description: 给出集合[1,2,3,...,n]，其所有元素共有n!种排列。
 *               按大小顺序列出所有排列情况，并一一标记，当n = 3 时, 所有排列如下：
 *                  "123"
 *                  "132"
 *                  "213"
 *                  "231"
 *                  "312"
 *                  "321"
 *               给定n 和k，返回第k个排列。
 *                  输入：n = 3, k = 3
 *                  输出："213"
 *                  输入：n = 4, k = 9
 *                  输出："2314"
 *                  输入：n = 3, k = 1
 *                  输出："123"
 *               提示： 1 <= n <= 9
 *                     1 <= k <= n!
 * @author: jguo
 * @date: 2021/7/14
 */
public class lt_60 {

    public String getPermutation(int n, int k) {
        if(k <= 0 || n<= 0 ){
            return "输入不符合要求";
        }
        k--;
        int[] factorial = new int[n];
        factorial[0] = 1;
        //先记录好每个地方的阶乘结果
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i-1] * i;
        }
        List<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        StringBuilder sb = new StringBuilder();
        //i表示剩余的数字个数，初始化为n-1
        for (int i = n-1; i >= 0; i--) {
            int index = k / factorial[i];
            sb.append(nums.remove(index));
            k = k - index * factorial[i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入n：");
        int n = in.nextInt();
        System.out.println("请输入k：");
        int k = in.nextInt();
        lt_60 solution = new lt_60();
        System.out.println("给出集合[1,2,3,...,n]，其所有元素共有n!种排列。大小顺序排列后，得到第k个排列：");
        System.out.println(solution.getPermutation(n, k));
    }
}
