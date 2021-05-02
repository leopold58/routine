package com.gj.routine.lt;

import java.util.Scanner;

/**
 * lt-14.最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串""。
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 提示：
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class lt_14 {
    public String longestCommonPrefix(String[] strs){
        if (strs == null || strs.length == 0) return "";
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String cur = strs[i];
            int j = 0;
            for (; j < strs[i].length() && j< res.length(); j++) {
                if (res.charAt(j)!=cur.charAt(j)){
                    break;
                }
            }
            res = cur.substring(0,j);
            if (res.equals("")) return "";
        }
        return res;
    }

    public static void main(String[] args) {
        lt_14 solution = new lt_14();
        Scanner in = new Scanner(System.in);
        System.out.print("请输入个数：");
        int num = in.nextInt();
        String[] strs = new String[num];
        System.out.println("请输入字符串：");
        for (int i = 0; i < num; i++) {
            strs[i] = in.next();
        }
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
