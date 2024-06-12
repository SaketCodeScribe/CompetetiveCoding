package com.dsa_algorithms.Tree;

public class MaxPathSumBetTwoLeaves {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }
    static long ans;
    public static long findMaxSumPath(TreeNode root) {
        // Write your code here.
        ans = -1;
        maxPathSum(root);
        return ans;
    }
    public static long maxPathSum(TreeNode root){
        if (root == null)
            return -1;
        if (root.left == null && root.right == null)
            return root.data;
        long leftSum = maxPathSum(root.left);
        long rightSum = maxPathSum(root.right);
        if (leftSum != -1 && rightSum != -1 && ans < leftSum+rightSum+root.data)
            ans = leftSum+rightSum+root.data;
        return Math.max(leftSum, rightSum)+root.data;
    }
}
