package com.dsa_algorithms.Tree;

public class LC337 {
    public int rob(TreeNode root) {
        int[] cost = cost(root);
        return (int) Math.max(cost[0], cost[1]);
    }

    public int[] cost(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] leftCost = cost(root.left);
        int[] rightCost = cost(root.right);

        int inc = leftCost[1] + rightCost[1] + root.val;
        int exc = Math.max(leftCost[0], leftCost[1]) + Math.max(rightCost[0], rightCost[1]);
        return new int[]{inc, exc};
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
