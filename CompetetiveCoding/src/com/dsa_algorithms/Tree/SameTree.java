package com.dsa_algorithms.Tree;

public class SameTree {
    static class TreeNode{
        int val;
        TreeNode left, right;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if ((p == null && q != null) || (p != null && q == null))
            return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
