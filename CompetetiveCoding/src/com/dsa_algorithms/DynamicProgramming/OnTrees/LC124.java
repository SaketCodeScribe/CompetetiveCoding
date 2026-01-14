package com.dsa_algorithms.DynamicProgramming.OnTrees;

public class LC124 {
    public int maxPathSum(TreeNode root) {
        int[] pathSum = solve(root);
        return Math.max(pathSum[0], pathSum[1]);
    }

    private int[] solve(TreeNode node){
        if (node == null){
            return new int[]{-200000, -200000};
        }
        int[] left = solve(node.left);
        int leftpath = left[0], leftSubTree = left[1];
        int[] right = solve(node.right);
        int rightpath = right[0], rightSubTree = right[1];

        int includeLeft = node.val + leftpath;
        int includeRight = node.val + rightpath;
        int includeBoth = node.val + leftpath + rightpath;
        int excludeBoth = node.val;
        int subTree = Math.max(Math.max(includeBoth, excludeBoth), Math.max(Math.max(leftpath, includeLeft), Math.max(rightpath, includeRight)));

        return new int[]{Math.max(excludeBoth, Math.max(includeLeft, includeRight)), Math.max(subTree, Math.max(leftSubTree, rightSubTree))};
    }
}
