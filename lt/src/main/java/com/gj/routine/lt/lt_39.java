package com.gj.routine.lt;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @title: 组合总和
 * @description: 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *               candidates中的数字可以无限制重复被选取。
 *               说明：
 *                  所有数字（包括target）都是正整数。
 *                  解集不能包含重复的组合。
 *               输入：candidates = [2,3,6,7], target = 7,
 *               所求解集为：
 *               [
 *                 [7],
 *                 [2,2,3]
 *               ]
 * @author: jguo
 * @date: 2021/5/19
 */
public class lt_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length==0 || candidates == null){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates,0, candidates.length, target, path, res);
        return res;
    }

    /**
     * 回溯   因为可以重复取值，所以递归的时候begin设置为i
     * @param candidates
     * @param begin
     * @param len
     * @param target
     * @param path 每种可能保存的结果
     * @param res 最终结果
     */
    public void dfs(int[] candidates,int begin,int len,int target,Deque<Integer> path,List<List<Integer>> res){
        if (target<0){
            return;
        }
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);
            dfs(candidates,i,len,target-candidates[i],path,res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        lt_39 solution = new lt_39();
        List<List<Integer>> result = solution.combinationSum(candidates,target);
        for (int i = 0; i < result.size(); i++) {
            for (Integer num:
                    result.get(i)) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}
