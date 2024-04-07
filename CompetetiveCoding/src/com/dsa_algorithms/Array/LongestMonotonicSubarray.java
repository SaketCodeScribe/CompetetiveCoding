package com.dsa_algorithms.Array;

public class LongestMonotonicSubarray {
    public int longestMonotonicSubarray(int[] nums) {
        int i, j, n = nums.length, ans=1, len = 1, len_ = 1;

        for(i=1; i<n; i++){
            if (nums[i] > nums[i-1])
                len++;
            else{
                ans = Math.max(ans, len);
                len = 1;
            }
            if (nums[i] < nums[i-1])
                len_++;
            else{
                ans = Math.max(ans, len_);
                len_ = 1;
            }
        }
        return Math.max(ans, Math.max(len, len_));
    }
}
