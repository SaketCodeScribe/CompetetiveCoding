package com.dsa_algorithms.Greedy.RangeGreedy_IntervalCovering;

public class LC55 {
    public boolean canJump(int[] nums) {
        int n = nums.length, i=0, maxEnd = nums[0], j = maxEnd;

        for(i=0; i<n && j<n; i++){
            maxEnd = Math.max(maxEnd, i+nums[i]);
            if (i == j){
                if (j == maxEnd && maxEnd < n-1){
                    return false;
                }
                j = maxEnd;
            }
        }
        return true;
    }
}
