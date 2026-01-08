package com.dsa_algorithms.Tree.Traversal;

public class LC1339 {
    static class TreeNode{
        int val;
        TreeNode left, right;

    }
    private static final int MOD = 1_000_000_007;
    public int maxProduct(TreeNode root) {
        long sum = findTotalSum(root);
        return (int)(maxProduct(root, sum)[1]%MOD);
    }
    private long[] maxProduct(TreeNode root, long sum){
        long[] arr = new long[2];
        if (root == null){
            return arr;
        }

        long[] a = maxProduct(root.left, sum);
        long[] b = maxProduct(root.right, sum);
        long sumA = a[0], sumB = b[0];
        arr[0] = (sumA + sumB + root.val);
        arr[1] = Math.max(a[1], b[1]);
        arr[1] = Math.max(arr[1], sumA*(sum-sumA));
        arr[1] = Math.max(arr[1], sumB*(sum-sumB));

        return arr;
    }
    private long findTotalSum(TreeNode root){
        if (root == null){
            return 0;
        }
        return (root.val + findTotalSum(root.left) + findTotalSum(root.right));
    }
}
