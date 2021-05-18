package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 外观数列
 * @description: 给定一个正整数 n ，输出外观数列的第 n 项。
 *              「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *               你可以将其视作是由递归公式定义的数字字符串序列：
 *               countAndSay(1) = "1"
 *               countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 *               前五项：
 *               1.     1
 *               2.     11
 *               3.     21
 *               4.     1211
 *               5.     111221
 *               第一项是数字 1
 *               描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 *               描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 *               描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 *               描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 *               提示：1 <= n <= 30
 * @author: jguo
 * @date: 2021/5/18
 */
public class lt_38 {

    public String countAndSay(int n){
        if (n == 1)return "1";
        String s = "1";
        for (int i = 0; i < n-1; i++) {
            s = describe(s);
        }
        return s;
    }
    //采用一个num的变量来计算当前的字符的数量，当字符与之前统计的不同时，进行写入到sb中。
    public String describe(String s){
        StringBuffer sb = new StringBuffer();
        if (s.length() == 1){
            sb.append("1");
            sb.append(s);
        }
        int num = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)){
                num++;
                if (i == s.length()-1){
                    sb.append(num);
                    sb.append(s.charAt(i-1));
                }
            }else {
                sb.append(num);
                sb.append(s.charAt(i-1));
                num = 1;
                if (i == s.length()-1){
                    sb.append(num);
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        lt_38 solution = new lt_38();
        System.out.println(solution.countAndSay(n));
    }
}
