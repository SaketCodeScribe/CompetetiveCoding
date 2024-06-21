package com.dsa_algorithms.Tree;

public class MinDepthOfABinaryTree {
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }
    public static int minDepth(BinaryTreeNode<Integer> root) {
        // Write your code here.
        if(root == null)
            return 0;
        if (root.right == null && root.left == null)
            return 1;
        return Math.min(root.left == null ? Integer.MAX_VALUE : minDepth(root.left),
                root.right == null ? Integer.MAX_VALUE : minDepth(root.right))+1;
    }
}
