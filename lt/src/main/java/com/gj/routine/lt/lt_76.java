package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 最小覆盖子串
 * @description: 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *               注意：
 *               对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 *               如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *               示例 1：
 *                  输入：s = "ADOBECODEBANC", t = "ABC"
 *                  输出："BANC"
 *               示例 2：
 *                  输入：s = "a", t = "a"
 *                  输出："a"
 *               示例 3:
 *                  输入: s = "a", t = "aa"
 *                  输出: ""
 *                  解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 *                  因此没有符合条件的子字符串，返回空字符串。
 *              提示：
 *                  1 <= s.length, t.length <= 105
 *                   s 和 t 由英文字母组成
 * @author: jguo
 * @date: 2021/7/28
 */
public class lt_76 {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0)
            return "";
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int l = 0,r = 0,size = Integer.MAX_VALUE,count = t.length(),start = 0;
        while (r<s.length()){
            char c = s.charAt(r);
            if (need[c] > 0){
                count--;
            }
            need[c]--;
            if (count == 0){
                while (l<r && need[s.charAt(l)]< 0){
                    need[s.charAt(l)]++;
                    l++;
                }
                if (r-l+1<size){
                    size = r-l+1;
                    start = l;
                }
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE? "":s.substring(start,start+size);
    }

    public static void main(String[] args) {
        System.out.println("给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。");
        Scanner in = new Scanner(System.in);
        System.out.println("字符串s：");
        String s = in.nextLine();
        System.out.println("字符串t：");
        String t = in.nextLine();
        lt_76 solution = new lt_76();
        System.out.println("最小字串：");
        System.out.println(solution.minWindow(s, t));

    }
}
