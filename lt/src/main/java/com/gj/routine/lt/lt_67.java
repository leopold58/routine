package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 二进制求和
 * @description: 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *               输入为 非空 字符串且只包含数字 1 和 0。
 *               示例1:
 *               输入: a = "11", b = "1"
 *               输出: "100"
 *               示例2:
 *               输入: a = "1010", b = "1011"
 *               输出: "10101"
 *               提示：
 *                  每个字符串仅由字符 '0' 或 '1' 组成。
 *                  1 <= a.length, b.length <= 10^4
 *                  字符串如果不是 "0" ，就都不含前导零。
 * @author: jguo
 * @date: 2021/7/17
 */
public class lt_67 {

    public String addBinary(String a, String b) {
        if (a == null || a.length()==0)return b;
        if (b == null || b.length()==0)return a;
        int n = Math.max(a.length(),b.length());
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            carry += i < a.length()? (a.charAt(a.length()-i-1)-'0'):0;
            carry += i < b.length()? (b.charAt(b.length()-i-1)-'0'):0;
            sb.append((char)(carry%2+'0'));
            carry /= 2;
        }
        if (carry > 0){
            sb.append('1');
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入二进制字符串（只能为1和0）,第一个：");
        String a = in.nextLine();
        System.out.println("第二个：");
        String b = in.nextLine();
        lt_67 solution = new lt_67();
        System.out.println("二进制做和的结果：");
        System.out.println(solution.addBinary(a, b));
    }
}
