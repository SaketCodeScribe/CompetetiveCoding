package com.dsa_algorithms.Tree;

public class MaxSumOfNodes {
    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;
        TreeNode(T data) {
            this.data = data;
        }
    };
    public static int maximumSumOfNodes(TreeNode<Integer> root)
    {
        //    Write your code here.
        int[] ans = maxSum(root);
        return Math.max(ans[0], ans[1]);
    }
    public static int[] maxSum(TreeNode<Integer> root){
        if (root == null)
            return new int[]{0,0};
        int[] left = maxSum(root.left);
        int[] right = maxSum(root.right);
        return new int[]{root.data+left[1]+right[1],
                Math.max(left[0], left[1])+Math.max(right[0], right[1])};
    }
}
