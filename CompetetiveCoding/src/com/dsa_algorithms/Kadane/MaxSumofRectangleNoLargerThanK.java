package com.dsa_algorithms.Kadane;

import java.util.TreeSet;

public class MaxSumofRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int tar) {
        int i, j, k, m = matrix.length, n = matrix[0].length, maxSum = Integer.MIN_VALUE;
        int[] dp;
        TreeSet<Integer> tree ;
        for(i=0; i<m; i++){
            dp = new int[n];
            for(j=i; j<m; j++){
                for(k=0; k<n; k++)
                    dp[k] += matrix[j][k];
                tree = new TreeSet<>();
                tree.add(0);
                int sum = 0;
                for(k=0; k<n; k++){
                    sum += dp[k];
                    Integer val = tree.ceiling(sum-tar);
                    if (val != null)
                        maxSum = Math.max(maxSum, sum-val);
                    tree.add(sum);
                }
            }
        }
        return maxSum;
    }
}
