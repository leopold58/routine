package com.gj.routine.lt;

import java.util.*;

/**
 *
 * @title: 全排列
 * @description: 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *               示例 1：
 *               输入：nums = [1,2,3]
 *               输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *               示例 2：
 *               输入：nums = [0,1]
 *               输出：[[0,1],[1,0]]
 *               示例 3：
 *               输入：nums = [1]
 *               输出：[[1]]
 * @author: jguo
 * @date: 2021/6/10
 */
public class lt_46 {

//    //广度优先遍历和回溯的结合
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (nums == null || nums.length == 0){
//            return res;
//        }
//        int len = nums.length;
//        boolean[] used = new boolean[len];
//        Deque<Integer> temp = new ArrayDeque<>(len);
//        dfs(res,temp,0,len,used,nums);
//        return res;
//    }
//    public void dfs(List<List<Integer>> res, Deque<Integer> temp, int start, int len, boolean[] used,int[] nums){
//        if (start == len){
//            res.add(new ArrayList<>(temp));
//            return;
//        }
//        //理解为什么从0开始，其中进行了使用的标记等工作
//        for (int i = 0; i < len; i++) {
//            if (!used[i]){
//                temp.addLast(nums[i]);
//                used[i] = true;
//                dfs(res,temp,start+1,len,used,nums);
//                used[i] = false;
//                temp.removeLast();
//            }
//        }
//    }

    //回溯的算法，比较好理解,不用占用多余的空间，在原数组中进行移动

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> output = new LinkedList<>();
        backTrack(nums,0,output);
        return output;
    }
    public void backTrack(int[] nums,int k,List<List<Integer>> output){
        if (k == nums.length){
            List<Integer> t = new LinkedList<>();
            for (int n:nums) {
                t.add(n);
            }
            output.add(t);
            return;
        }
        for (int i = k; i < nums.length; i++) {
            int temp = nums[k];
            nums[k] = nums[i];
            nums[i] = temp;
            backTrack(nums,k+1,output);
            temp = nums[k];
            nums[k] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] sTemp = s.split(",");
        int[] nums = new int[sTemp.length];
        for (int i = 0; i < sTemp.length; i++) {
            nums[i] = Integer.parseInt(sTemp[i]);
        }
        lt_46 solution = new lt_46();
        List<List<Integer>> result = solution.permute(nums);
        System.out.println(result);

    }

}
