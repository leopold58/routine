package com.gj.routine.lt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lt_199 {

//    List<Integer> res = new ArrayList<>();
//    public List<Integer> rightSideView(TreeNode root){
//        dfs(root, 0);
//        return res;
//    }
//    public void dfs(TreeNode root, int depth){
//        if (root == null){
//            return;
//        }
//        if (depth==res.size()){
//            res.add(root.val);
//        }
//        depth++;
//        dfs(root.right, depth);
//        dfs(root.left, depth);
//    }

    public List<Integer> rightSideView(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                if (i == size-1){
                    res.add(node.val);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        lt_199 solution = new lt_199();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode l1 = new TreeNode(5);
        TreeNode right = new TreeNode(3);
        TreeNode r1 = new TreeNode(4);
        root.left=left;
        left.right=l1;
        root.right=right;
        right.right=r1;
        List<Integer> res = solution.rightSideView(root);
        System.out.println(res);


    }
}
