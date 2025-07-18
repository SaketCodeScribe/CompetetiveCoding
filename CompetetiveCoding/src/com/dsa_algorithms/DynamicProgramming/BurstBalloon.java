package com.dsa_algorithms.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

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

//        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
        List<checkme> arr = new ArrayList<>();
        arr.add(new checkme(56));
        print(arr);
    }

    private static void print(List<checkme> arr) {
        System.out.println("--->"+arr.get(0).getClass().getName());
    }

    static class checkme{
        int val;
        public checkme(int val){
            this.val = val;
        }
    }
}
