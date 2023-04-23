package com.gj.routine.lt;

import java.util.LinkedList;
import java.util.Queue;

public class lt_104 {

    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        lt_104 solution = new lt_104();
        TreeNode root = new TreeNode(3);
        TreeNode f1left = new TreeNode(9);
        TreeNode f1right = new TreeNode(20);
        TreeNode f1rLeft = new TreeNode(15);
        TreeNode f1rRight = new TreeNode(7);
        root.left = f1left;
        root.right = f1right;
        f1right.left = f1rLeft;
        f1right.right = f1rRight;
        int res = solution.maxDepth(root);
        System.out.println(res);
    }
}
