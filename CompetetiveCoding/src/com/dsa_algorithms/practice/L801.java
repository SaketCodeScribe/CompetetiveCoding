package com.dsa_algorithms.practice;

public class L801 {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[][] dp = new Integer[n][2];

        return Math.min(minOperations(nums1, nums2, n, 1, 0, dp),
                minOperations(nums1, nums2, n, 1, 1, dp)+1);
    }
    private int minOperations(int[] nums1, int[] nums2, int n, int i, int parity, Integer[][] dp){
        if (i >= n){
            return 0;
        }
        if (dp[i][parity] != null){
            return dp[i][parity];
        }
        int ans = Integer.MAX_VALUE;
        if (parity == 0){
            if (nums1[i] > nums1[i-1] && nums2[i] > nums2[i-1]){
                ans = minOperations(nums1, nums2, n, i+1, 0, dp);
            }
            if (nums1[i] > nums2[i-1] && nums2[i] > nums1[i-1]){
                ans = Math.min(ans, minOperations(nums1, nums2, n, i+1, 1, dp)+1);
            }
        }
        else{
            if (nums1[i] > nums2[i-1] && nums2[i] > nums1[i-1]){
                ans = minOperations(nums1, nums2, n, i+1, 0, dp);
            }
            if (nums1[i] > nums1[i-1] && nums2[i] > nums2[i-1]){
                ans = Math.min(ans, minOperations(nums1, nums2, n, i+1, 1, dp)+1);
            }
        }
        return dp[i][parity] = ans;
    }
}
