package com.gj.routine.lt;

import java.util.*;

/**
 * @title: 子集
 * @description: 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *               解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *               示例 1：
 *                  输入：nums = [1,2,3]
 *                  输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *               示例 2：
 *                  输入：nums = [0]
 *                  输出：[[],[0]]
 *               提示：
 *                  1 <= nums.length <= 10
 *                  -10 <= nums[i] <= 10
 *                  nums 中的所有元素 互不相同
 * @author: jguo
 * @date: 2021/7/31
 */
public class lt_78 {

    /**
     * 回溯
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        for (int i = 0; i <= nums.length; i++) {
            dfs(res,path,i,0,nums);
        }
        return res;
    }

    public void dfs(List<List<Integer>> ans, Deque<Integer> path,int len,int begin,int[] nums){
        if (path.size() == len){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            path.addLast(nums[i]);
            dfs(ans, path, len, i+1, nums);
            path.removeLast();
        }
    }

    /**
     * 回溯
     * @param args
     */
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        backtrack(0, nums, res, new ArrayList<Integer>());
//        return res;
//
//    }
//
//    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
//        res.add(new ArrayList<>(tmp));
//        for (int j = i; j < nums.length; j++) {
//            tmp.add(nums[j]);
//            backtrack(j + 1, nums, res, tmp);
//            tmp.remove(tmp.size() - 1);
//        }
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入一串数字：(逗号隔开)");
        String s = in.nextLine();
        String[] sInput = s.trim().split(",");
        int[] nums = new int[sInput.length];
        for (int i = 0; i < sInput.length; i++) {
            nums[i] = Integer.parseInt(sInput[i]);
        }
        System.out.println("输出子集：");
        lt_78 solution = new lt_78();
        System.out.println(solution.subsets(nums));
    }
}
