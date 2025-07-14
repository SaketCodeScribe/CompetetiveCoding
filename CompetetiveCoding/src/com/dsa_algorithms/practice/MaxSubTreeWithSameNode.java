package com.dsa_algorithms.practice;

public class MaxSubTreeWithSameNode {
    static class Tree{
        int val;
        Tree left, right;
    }
    static class Result{
        int ans;
    }
    public int maxSubTreeSize(Tree root){
        Result result = new Result();
        postOrderTraversal(root, result);
        return result.ans;
    }
    private int postOrderTraversal(Tree root, Result result){
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int leftSize = postOrderTraversal(root.left, result);
        int rightSize = postOrderTraversal(root.right, result);
        if (leftSize == -1 || rightSize == -1){
            return -1;
        }
        if ((root.left == null || root.val == root.left.val)
                && (root.right == null || root.val == root.right.val )){
            int val = leftSize + rightSize + 1;
            if (result.ans < val) {
                result.ans = val;
            }
            return val;
        }
        return -1;
    }
}
