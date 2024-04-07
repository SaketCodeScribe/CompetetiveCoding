package com.dsa_algorithms.Tree;

public class LCA {
    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.val = data;
            left = null;
            right = null;
        }
    }
    TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca = null;
        findLca(root, p, q);
        return lca;
    }
    public boolean findLca(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return false;
        boolean left = findLca(root.left, p, q);
        boolean right = findLca(root.right, p, q);
        if (((root.val == p.val || root.val == q.val) && (left || right)) || (left && right)){
            lca = root;
            return true;
        }
        return root.val == p.val || root.val == q.val;
    }
}
