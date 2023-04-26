package com.gj.routine.lt;

public class lt_100 {

    public boolean isSameTree(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }else if (p == null || q == null){
            return false;
        }else if (p.val!=q.val){
            return false;
        }else {
            return isSameTree(p.left, q.right) && isSameTree(p.right, q.right);
        }
    }
    public static void main(String[] args) {
        lt_100 solution = new lt_100();
        TreeNode p = new TreeNode(1);
        TreeNode pl1 = new TreeNode(2);
        TreeNode pr1 = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        TreeNode ql1 = new TreeNode(2);
        TreeNode qr1 = new TreeNode(3);
        p.left=pl1;
        p.right=pr1;
        q.left=ql1;
        q.right=qr1;
        boolean res = solution.isSameTree(p, q);
        System.out.println(res);




    }
}
