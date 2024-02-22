package com.dsa_algorithms.DynamicProgramming;

public class BurstBalloon {
    public static int maxCoins(int[] nums) {
        int i, j, k, n = nums.length, mx;
        int[][] dp = new int[n][n];

        for (i = 0; i < n; i++) {
            for (j = i; j >=0; j--) {
                mx = 0;
                for (k = j; k<=i; k++)
                    mx = Math.max(mx, nums[k] * (j == 0 ? 1: nums[j - 1]) * (i == n-1 ? 1 : nums[i+1]) + (k == j ? 0:dp[j][k - 1]) + (k==i ? 0: dp[k+1][i]));
                dp[j][i] = mx;
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
    }
}
