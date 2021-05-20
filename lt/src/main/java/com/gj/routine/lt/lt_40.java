package com.gj.routine.lt;

import java.util.*;

/**
 * @title: 组合总和 II
 * @description: 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *               candidates 中的每个数字在每个组合中只能使用一次。
 *               说明：
 *                  所有数字（包括target）都是正整数。
 *                  解集不能包含重复的组合。
 *               输入: candidates =[10,1,2,7,6,1,5], target =8,
 *                  所求解集为:
 *                  [
 *                      [1, 7],
 *                      [1, 2, 5],
 *                      [2, 6],
 *                      [1, 1, 6]
 *                  ]
 * @author: jguo
 * @date: 2021/5/20
 */
public class lt_40 {

    public List<List<Integer>> combinationSum2(int[] candidates,int target){
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0 || candidates == null){
            return res;
        }
        //TODO:排序可以提高算法执行的效率。
        Arrays.sort(candidates);
        int len = candidates.length;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates,0,len,target,path,res);
        return res;
    }
    public void dfs(int[] candidates,int begin,int len,int target,Deque<Integer> path,List<List<Integer>> res){
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            if (target-candidates[i]<0){
                break;
            }
            //TODO:本题目中解集中不包含重复的组合，故需要去重操作。
            if (i>begin && candidates[i] == candidates[i-1]){
                continue;
            }
            path.addLast(candidates[i]);
            dfs(candidates, i+1, len, target-candidates[i], path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        lt_40 solution = new lt_40();
        List<List<Integer>> result = solution.combinationSum2(candidates,target);
        for (int i = 0; i < result.size(); i++) {
            for (Integer num:
                    result.get(i)) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

}
