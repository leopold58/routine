package com.gj.routine.lt;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * lt-8.字符串转换整数(atoi)
 * 请你来实现一个atoi函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * 注意：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为[−231, 231− 1]。如果数值超过这个范围，请返回 231− 1 或 −231 。
 *
 * 示例1:
 * 输入: "42"
 * 输出: 42
 *
 * 示例2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 *
 * 示例3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 *
 * 示例4:
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 *
 * 示例5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *    因此返回 INT_MIN (−231) 。
 *
 * 提示：
 * 0 <= s.length <= 200
 * s 由英文字母（大写和小写）、数字、' '、'+'、'-' 和 '.' 组成
 */
public class lt_8 {
    public int myAtoi(String s){
        if (s == null || s.length() == 0)
            return  0;
        int index = 0;
        char[] arrs = s.toCharArray();
        while (index< arrs.length && arrs[index] == ' '){
            index++;
        }
        if (index == arrs.length) return 0;
        int sign = 1;
        if (arrs[index] == '-'){
            sign = -1;
            index++;
        }else if (arrs[index] == '+'){
            index++;
        }
        int res = 0;
        while (index< arrs.length){
            char cur = arrs[index];
            if (cur > '9' || cur < '0'){
                break;
            }
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && (cur-'0')>Integer.MAX_VALUE % 10))
                return Integer.MAX_VALUE;
            if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && (cur-'0')>-(Integer.MIN_VALUE % 10)))
                return Integer.MIN_VALUE;
            res = res *10 + sign * (cur - '0');  //做正负数的组合数字
            index++;
        }
        return res;

    }

    public static void main(String[] args) {
        lt_8 solution = new lt_8();
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(solution.myAtoi(s));
    }

    //自动机
/*    public int myAtoi(String s){
        Automaton automaton = new Automaton();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            automaton.get(s.charAt(i));
        }
        return (int)(automaton.sign * automaton.ans);
    }*/

}
/*class Automaton{
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String,String[]> table = new HashMap<String,String[]>(){{
        put("start",new String[]{"start","signed","in_number","end"});
        put("signed",new String[]{"end","end","in_number","end"});
        put("in_number",new String[]{"end","end","in_number","end"});
        put("end",new String[]{"end","end","end","end"});
    }};

    public void get(char c){
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)){
            ans = ans * 10 + c - '0';
            ans = sign == 1? Math.min(ans,(long)Integer.MAX_VALUE):Math.min(ans,-(long)Integer.MIN_VALUE);
        }else if ("signed".equals(state)){
            sign = c == '+'? 1:-1;
        }
    }
    private int get_col(char c){
        if (c == ' '){
            return 0;
        }
        if (c == '+' || c == '-'){
            return 1;
        }
        if (Character.isDigit(c)){
            return 2;
        }
        return 3;
    }
}*/
