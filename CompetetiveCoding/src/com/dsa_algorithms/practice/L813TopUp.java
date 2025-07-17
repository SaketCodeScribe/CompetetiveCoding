package com.dsa_algorithms.practice;

public class L813TopUp {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] prefixSum = new double[n+1];
        Double[][] dp = new Double[n+1][k+1];

        for(int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1]+nums[i-1];
        }

        return getMaxScore(prefixSum, n, 1, k, dp);
    }

    private double getMaxScore(double[] prefixSum, int n, int i, int k, Double[][] dp) {
        if (i > n && k == 0){
            return 0;
        }
        if (i > n || k == 0){
            return Integer.MIN_VALUE;
        }
        if (dp[i][k] != null){
            return dp[i][k];
        }
        double maxScore = 0;
        for(int j=i; j<n; j++){
            maxScore = Math.max(maxScore, getMaxScore(prefixSum, n, j+1, k-1, dp) + (prefixSum[j]-prefixSum[i-1])/(j-i+1));
        }
        return dp[i][k] = maxScore;
    }
}
