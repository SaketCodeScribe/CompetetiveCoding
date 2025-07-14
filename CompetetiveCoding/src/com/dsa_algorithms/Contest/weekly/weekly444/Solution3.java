package com.dsa_algorithms.Contest.weekly.weekly444;

    public class Solution3 {
        public int minXor(int[] nums, int k) {
            int n = nums.length;
            Integer[][] dp = new Integer[n][k+1];
            solve(nums, n, 0, k, dp);
            return dp[n-1][k];
        }
        private int solve(int[] nums, int n, int i, int k, Integer[][] dp){
            if (i == n){
                return k == 0 ? 0 : Integer.MAX_VALUE;
            }
            if (k == 0){
                return Integer.MAX_VALUE;
            }
            if (dp[i][k] != null){
                return dp[i][k];
            }
            int xor = 0, ans = Integer.MAX_VALUE;
            for(int j=i; j<n; j++){
                xor ^= nums[j];
                ans = Math.min(ans, Math.max(xor, solve(nums, n, j+1, k-1, dp)));
            }
            return dp[i][k] = ans;
        }
}
