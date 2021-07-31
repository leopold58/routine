package com.gj.routine.lt;

import java.util.*;

/**
 * @title: 组合
 * @description: 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *               你可以按 任何顺序 返回答案。
 *               示例 1：
 *                  输入：n = 4, k = 2
 *                  输出：
 *                  [
 *                      [2,4],
 *                      [3,4],
 *                      [2,3],
 *                      [1,2],
 *                      [1,3],
 *                      [1,4],
 *                  ]
 *                示例 2：
 *                  输入：n = 1, k = 1
 *                  输出：[[1]]
 *                提示：
 *                  1 <= n <= 20
 *                  1 <= k <= n
 * @author: jguo
 * @date: 2021/7/30
 */
public class lt_77 {

    /**
     * 经典回溯，注意在遍历的时候的范围。
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n,int k){
        List<List<Integer>> res = new ArrayList<>();
        if (k<=0 || n<k){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(res, path, n, k, 1);
        return res;
    }
    public void dfs(List<List<Integer>> ans, Deque<Integer> path, int n, int k, int begin){
        if (path.size() == k){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            dfs(ans, path, n, k, i+1);
            path.removeLast();
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        lt_77 solution = new lt_77();
        System.out.println(solution.combine(n, k));
    }
}
