package com.dsa_algorithms.DynamicProgramming;

public class MaximumSumRectangle {
    int maximumSumRectangle(int r, int c, int m[][]) {
        // code here
        int i, j, k, max = Integer.MIN_VALUE;
        int[] dp;

        for(i=0; i<r; i++){
            dp = new int[c];
            for(j=i; j<r; j++){
                for(k=0; k<c; k++)
                    dp[k] += m[j][k];
                max = Math.max(max, maxSum(dp,c));
            }
        }
        return max;
    }
    public int maxSum(int[] dp, int n){
        int i, sum = 0, mSum = Integer.MIN_VALUE;
        for(i=0; i<n; i++){
            sum += dp[i];
            mSum = Math.max(mSum, sum);
            if (sum < 0)
                sum = 0;
        }
        return mSum;
    }
}
