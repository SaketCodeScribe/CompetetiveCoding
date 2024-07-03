package com.dsa_algorithms.SlidingWindow;

public class MinimizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int i, j, n = nums.length, ans = Integer.MAX_VALUE;
        long sum = 0;
        i = j = 0;
        while(i < n){
            sum += nums[i];
            while(j <= i && sum >= target){
                ans = Math.min(ans, i-j+1);
                sum -= nums[j++];
            }
            i++;
        }
        return ans != Integer.MAX_VALUE ? ans : 0;
    }
}
