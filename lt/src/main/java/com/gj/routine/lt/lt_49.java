package com.gj.routine.lt;

import java.util.*;

/**
 * @title: 字母异位词分组
 * @description: 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *               示例:
 *               输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 *               输出:
 *                  [
 *                    ["ate","eat","tea"],
 *                    ["nat","tan"],
 *                    ["bat"]
 *                  ]
 *                说明：所有输入均为小写字母。
 *                     不考虑答案输出的顺序。
 * @author: jguo
 * @date: 2021/6/30
 */

public class lt_49 {

    //第一种：排序
    public List<List<String>> groupAnagrams(String[] strs){
        HashMap<String,List<String>> map = new HashMap<>();
        for (String s:
             strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> lists = map.getOrDefault(key,new ArrayList<>());
            lists.add(s);
            map.put(key,lists);
        }
        return new ArrayList<List<String>>(map.values());
    }

    //第二种：计数
//    public List<List<String>> groupAnagrams(String[] strs){
//        Map<String,List<String>> map = new HashMap<>();
//        for (String s:
//             strs) {
//            int[] count = new int[26];
//            int length = s.length();
//            for (int i = 0; i < length; i++) {
//                count[s.charAt(i) - 'a']++;
//            }
//            StringBuffer sb = new StringBuffer();
//            for (int i = 0; i < 26; i++) {
//                if (count[i]!=0){
//                    sb.append((char)('a'+i));
//                    sb.append(count[i]);
//                }
//            }
//            String key = sb.toString();
//            List<String> lists = map.getOrDefault(key,new ArrayList<String>());
//            lists.add(s);
//            map.put(key,lists);
//        }
//        return new ArrayList<List<String>>(map.values());
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入字符串数组，每个字符串之间采用逗号‘,’隔开：");
        String s = in.nextLine();
        String[] sInput = s.trim().split(",");
        lt_49 solution = new lt_49();
        List<List<String>> result = solution.groupAnagrams(sInput);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j)+ " ");
            }
            System.out.println();
        }
    }
}
