package com.dsa_algorithms.BinarySearchTree;

public class ValidateBST {
    static class BinaryTreeNode<T> {
        public T data;
        public BinaryTreeNode<T> left;
        public BinaryTreeNode<T> right;

        BinaryTreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static boolean validateBST(BinaryTreeNode<Integer> root)
    {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    static boolean isValid(BinaryTreeNode<Integer> root, int min, int max){
        if (root == null)
            return true;
        if (root.data > min && root.data < max){
            boolean left = isValid(root.left, min, root.data);
            boolean right = isValid(root.right, root.data, max);
            return left && right;
        }
        return false;
    }
}
