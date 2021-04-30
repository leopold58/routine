package com.gj.routine.lt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jguo
 * @date 2021/4/28
 * 描述：
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */

public class lt_102 {

    /**
     *
     * @param root 层序遍历的root节点
     * @return     返回List<List<List<Integer>>>
     */
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            int iterSize = queue.size();
            for (int i = 0; i < iterSize; i++) {
                TreeNode node = queue.poll();
                tempList.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            result.add(tempList);
        }
        return result;
    }

    public static void main(String[] args) {
        //构建二叉树

        TreeNode test_node = new TreeNode(0);
        //调用levelOrder函数
        lt_102 solution = new lt_102();
        System.out.println(solution.levelOrder(test_node));
    }
}
