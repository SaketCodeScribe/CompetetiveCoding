package com.dsa_algorithms.DynamicProgramming;

public class LC312 {
    public int maxCoins(int[] nums) {
        int n = nums.length, i, j, k;

        long[][] dp = new long[n][n];

        for(i=1; i<=n; i++) {
            for(j=0; j<=n-i; j++) {
                for(k=j; k <= j+i-1; k++) {
                    dp[j][j+i-1] = Math.max(
                            dp[j][j+i-1],
                            leftCoins(dp, j, k) + leftBalloon(nums, j) * nums[k] * rightBalloon(nums, j+i-1) + rightCoins(dp, i, j, k));
                }
            }
        }
        return (int)dp[0][n-1];
    }
    private long leftBalloon(int[] nums, int index) {
        return index > 0 ? nums[index-1] : 1;
    }
    private long rightBalloon(int[] nums, int index) {
        return index < nums.length-1 ? nums[index+1] : 1;
    }
    private long leftCoins(long[][] dp, int j, int k) {
        return k > j ? dp[j][k-1] : 0;
    }
    private long rightCoins(long[][] dp, int i, int j, int k) {
        return k < j+i-1 ? dp[k+1][j+i-1] : 0;
    }
}
