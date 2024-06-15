package com.dsa_algorithms.BinarySearchTree;

public class ConvertBSTToGreaterSumTree {
    static class TreeNode<T> {
        T val;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
    public static TreeNode<Integer> convertBstToGreaterSum(TreeNode<Integer> root)
    {
        // Write your code here.
        createTree(root, 0);
        return root;
    }
    public static int createTree(TreeNode<Integer> root, int prevSum){
        if (root == null)
            return 0;
        int rightSum = createTree(root.right, prevSum);
        int temp = root.val;
        root.val = rightSum+prevSum;
        int leftSum = createTree(root.left, temp+root.val);
        return temp+rightSum+leftSum;
    }
}
