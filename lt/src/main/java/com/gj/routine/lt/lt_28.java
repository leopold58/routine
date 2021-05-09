package com.gj.routine.lt;

/**
 * @title: 实现 strStr()
 * @description: 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 *               说明：
 *               当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *               对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
 * @author: jguo
 * @date: 2021/5/5
 */
public class lt_28 {
    //暴力法
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return 0;
        int hayLen = haystack.length();
        int needLen = needle.length();
        if (hayLen < needLen) return -1;
        //注意这里是 <=
        for (int i = 0; i <= hayLen-needLen; i++) {
            boolean flag = true;
            for (int j = 0; j < needLen; j++) {
                if (needle.charAt(j) != haystack.charAt(i+j)){
                    flag = false;
                    break;
                }
            }
            if (flag){
                return i;
            }

        }
        return -1;
    }
    //kmp匹配方法
//    public int strStr(String haystack,String needle){
//        int n = haystack.length(), m = needle.length();
//        if (m == 0) {
//            return 0;
//        }
//        int[] pi = new int[m];
//        for (int i = 1, j = 0; i < m; i++) {
//            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
//                j = pi[j - 1];
//            }
//            if (needle.charAt(i) == needle.charAt(j)) {
//                j++;
//            }
//            pi[i] = j;
//        }
//        for (int i = 0, j = 0; i < n; i++) {
//            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
//                j = pi[j - 1];
//            }
//            if (haystack.charAt(i) == needle.charAt(j)) {
//                j++;
//            }
//            if (j == m) {
//                return i - m + 1;
//            }
//        }
//        return -1;
//    }
    //测试
    public static void main(String[] args) {
        lt_28 solution = new lt_28();
        String haystack = "hello";
        String needle = "ll";
        System.out.println(solution.strStr(haystack, needle));
    }

}
