package com.gj.routine.lt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @title: lt-17.电话号码的字母组合
 * @description:
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * @author: jguo
 * @date: 2021/4/30
 */
public class lt_17 {
    private String letterMap[] = {
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    private ArrayList<String> res;
    public List<String> letterCombinations(String digits){
        res = new ArrayList<String>();
        if (digits.equals(""))
            return res;
        findCombination(digits,0,"");
        return res;
    }
    private void findCombination(String digits,int index,String s){
        if (index == digits.length()){
            res.add(s);
            return;
        }
        Character c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index+1, s+letters.charAt(i));
        }
        return;
    }

    public static void main(String[] args) {
        lt_17 solution = new lt_17();
        Scanner in = new Scanner(System.in);
        String ssin = in.next();
        System.out.println(solution.letterCombinations(ssin));
    }

}



