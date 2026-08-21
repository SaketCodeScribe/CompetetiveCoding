package com.dsa_algorithms.DynamicProgramming;

public class LC416 {
    public boolean canPartition(int[] nums) {
        int sum = getSum(nums);
        if (sum % 2 != 0) return false;

        return canPartition(nums, sum/2);
    }

    private boolean canPartition(int[] nums, int target) {
        int i, j, n = nums.length;

        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for(i=0; i<n; i++) {
            for(j=target; j>=0; j--) {
                if (j >= nums[i]) dp[j] |= dp[j-nums[i]];
            }
        }
        return dp[target];
    }
    private int getSum(int[] nums) {
        int sum = 0;
        for(int num:nums) {
            sum += num;
        }
        return sum;
    }
}
