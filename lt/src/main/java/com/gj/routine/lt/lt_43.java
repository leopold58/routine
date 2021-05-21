package com.gj.routine.lt;

/**
 * @title: 字符串相乘
 * @description: 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *               示例 1:
 *               输入: num1 = "2", num2 = "3"
 *               输出: "6"
 *               示例2:
 *               输入: num1 = "123", num2 = "456"
 *               输出: "56088"
 *               说明：
 *               1.num1和num2的长度小于110。
 *               2.num1 和num2 只包含数字0-9。
 *               3.num1 和num2均不以零开头，除非是数字 0 本身。
 *               4.不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * @author: jguo
 * @date: 2021/5/21
 */
public class lt_43 {
    //采用字符串来进行计算  时间复杂度为mn+n2  效率较低

    //优化竖式计算，时间复杂度为mn 空间复杂度为m+n 效率较为良好
    public String multiply(String num1,String num2){
        if (num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int m = num1.length(),n = num2.length();
        int[] arr = new int[m+n];
        for (int i = m-1; i >= 0; i--) {
            int x = num1.charAt(i)-'0';
            for (int j = n-1; j >= 0 ; j--) {
                int y = num2.charAt(j) - '0';
                arr[i+j+1] += x * y;
            }
        }
        for (int i = m+n-1; i > 0; i--) {
            arr[i-1] += arr[i]/10;
            arr[i] %=10;
        }
        int begin = arr[0]==0? 1:0;
        StringBuffer sb = new StringBuffer();
        while (begin<m+n){
            sb.append(arr[begin]);
            begin++;
        }
        return sb.toString();
    }

    //卷积思路，c = a * b的思想 待研究

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        lt_43 solution = new lt_43();
        System.out.println(solution.multiply(num1, num2));
    }
}
