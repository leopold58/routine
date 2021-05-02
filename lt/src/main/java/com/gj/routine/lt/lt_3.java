package com.gj.routine.lt;

import java.util.HashMap;
import java.util.Scanner;

/**
 * lt-3.无重复字符的最长字串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class lt_3 {
    public static int lengthOfLongestSubstring(String s){
        if (s==null || s.length()==0) return 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int left = 0,len = 1;
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))){
                left = Math.max(left,hm.get(s.charAt(i))+1);
            }
            hm.put(s.charAt(i),i);
            len = Math.max(len,i-left+1);
        }
        return len;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
