package com.dsa_algorithms.Tree;

public class isHeightBalancedTree {
    static class TreeNode<T>
    {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static boolean isBalancedBT(TreeNode<Integer> root) {
        return isBalanced(root) != -1 ? true : false;
    }

    public static int isBalanced(TreeNode<Integer> root){
        if (root == null)
            return 0;
        int left = isBalanced(root.left);
        if (left == -1)
            return -1;
        int right = isBalanced(root.right);
        if (right == -1 || Math.abs(left-right) > 1)
            return -1;
        return Math.max(left, right)+1;
    }
}
