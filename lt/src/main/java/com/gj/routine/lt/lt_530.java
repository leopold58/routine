package com.gj.routine.lt;

public class lt_530 {
    int pre;
    int ans;
    public int getMinimumDifference(TreeNode root){
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        dfs(root.left);
        if (pre == -1){
            pre = root.val;
        }else {
            ans = Math.min(ans, root.val-pre);
            pre = root.val;
        }
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(6);
        TreeNode l1l = new TreeNode(1);
        TreeNode l1r = new TreeNode(3);
        root.left = l1;
        root.right = r1;
        l1.left = l1l;
        l1.right = l1r;
        lt_530 solution = new lt_530();
        int res = solution.getMinimumDifference(root);
        System.out.println(res);
    }
}
