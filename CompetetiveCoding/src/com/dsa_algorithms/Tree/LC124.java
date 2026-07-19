package com.dsa_algorithms.Tree;

public class LC124 {
    static class TreeNode {
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
    static class Result{
        private int sum;
        {
            this.sum = Integer.MIN_VALUE;
        }
        public int getSum(){
            return this.sum;
        }
        public void setSum(int sum){
            this.sum = sum;
        }
    }
    public int maxPathSum(TreeNode root) {
        Result result = new Result();
        maxPathSum(root, result);
        return result.getSum();
    }

    private int maxPathSum(TreeNode root, Result result){
        if (root == null) return 0;
        int leftSum = maxPathSum(root.left, result);
        int rightSum = maxPathSum(root.right, result);
        int max = Math.max(root.val, root.val + Math.max(leftSum, rightSum));
        result.setSum(Math.max(max, result.getSum()));
        result.setSum(Math.max(result.getSum(), root.val + leftSum + rightSum));

        return max;
    }
}
