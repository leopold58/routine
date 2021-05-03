package com.gj.routine.lt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @title: 括号生成
 * @description: 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *               输入：n = 3
 *               输出：["((()))","(()())","(())()","()(())","()()()"]
 *               输入：n = 1
 *               输出：["()"]
 * @author: jguo
 * @date: 2021/5/3
 */
public class lt_22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        backTrack(res,new StringBuilder(),0,0,n);
        return res;

    }
    public void backTrack(List<String> ans,StringBuilder sb, int left,int right,int max){
        if (sb.length() == max * 2){
            ans.add(sb.toString());
            return;
        }
        if (left<max){
            sb.append("(");
            backTrack(ans,sb,left+1,right,max);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right<left){
            sb.append(")");
            backTrack(ans,sb,left,right+1,max);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println("请输入需要生成的括号对数：");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        lt_22 solution = new lt_22();
        System.out.println(solution.generateParenthesis(n));
    }

}
