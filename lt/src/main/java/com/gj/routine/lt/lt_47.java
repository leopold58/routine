package com.gj.routine.lt;

import java.util.*;

/**
 * @title: 全排列 II
 * @description: 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *               示例 1：
 *               输入：nums = [1,1,2]
 *               输出：
 *               [[1,1,2],[1,2,1],[2,1,1]]
 * @author: jguo
 * @date: 2021/6/14
 */
public class lt_47 {

    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> output = new LinkedList<>();
        if (nums == null || nums.length == 0){
            return output;
        }
        Arrays.sort(nums);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] sTemp = s.split(",");
        int[] nums = new int[sTemp.length];
        for (int i = 0; i < sTemp.length; i++) {
            nums[i] = Integer.parseInt(sTemp[i]);
        }
        lt_47 solution = new lt_47();
        List<List<Integer>> result = solution.permuteUnique(nums);
        System.out.println(result);
    }

}
