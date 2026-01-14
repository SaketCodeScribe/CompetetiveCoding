package com.dsa_algorithms.DynamicProgramming.OnTrees;

public class LC337 {
    public int rob(TreeNode root) {
        int[] robbery = solve(root);
        return Math.max(robbery[0], robbery[1]);
    }
    private int[] solve(TreeNode node){
        if (node == null){
            return new int[2];
        }
        int[] left = solve(node.left);
        int leftChildInc = left[0], leftChildExc = left[1];
        int[] right = solve(node.right);
        int rightChildInc = right[0], rightChildExc = right[1];

        return new int[]{node.val + leftChildExc + rightChildExc, Math.max(leftChildInc, leftChildExc) + Math.max(rightChildInc, rightChildExc)};
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
