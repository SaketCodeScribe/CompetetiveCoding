package com.dsa_algorithms.BackTracking;

public class CanPartitionKSubsets {
    static boolean[] vis;
    public static boolean canPartitionKSubsets(int[] nums, int n, int k) {
        // Write your code here.
        vis = new boolean[n];
        long sum = 0;
        for(int num : nums)
            sum += num;
        if (sum % k > 0)
            return false;
        for(int num:nums)
            if (num > sum/k)
                return false;
        return dfs(0, 0, sum/k, nums.length, k, nums);
    }
    public static boolean dfs(int i, long sum, long tar, int n, int k, int[] nums){
        if (k == 0)
            return true;
        if (sum == tar)
            return dfs(0, 0, tar, n, k-1, nums);
        if (i == n)
            return false;

        if (!vis[i] && nums[i]+sum <= tar){
            vis[i] = true;
            if (dfs(i+1, sum+nums[i], tar, n, k, nums))
                return true;
            vis[i] = false;
            if (dfs(i+1, sum, tar, n, k, nums))
                return true;
        }
        else if (dfs(i+1, sum, tar, n, k, nums))
            return true;

        return false;
    }
}
