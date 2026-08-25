package com.dsa_algorithms.DynamicProgramming;

public class LC486 {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length, scores = 0;
        Integer[][] dp = new Integer[n][n];
        int[] prefix = new int[n];

        for(int i=0; i<n; i++){
            prefix[i] = prefix[Math.max(0,i-1)] + nums[i];
        }

        predictTheWinner(nums, prefix, dp, 0, n-1);

        return dp[0][n-1] >= prefix[n-1]/2.0;
    }
    private int predictTheWinner(int[] nums, int[] prefix, Integer[][] dp, int i, int j) {
        if (i > j) return 0;
        if (dp[i][j] != null) return dp[i][j];

        return dp[i][j] = prefix[j] - (i > 0 ? prefix[i-1] : 0)
                - Math.min(predictTheWinner(nums, prefix, dp, i+1, j),
                predictTheWinner(nums, prefix, dp, i, j-1));
    }
}
