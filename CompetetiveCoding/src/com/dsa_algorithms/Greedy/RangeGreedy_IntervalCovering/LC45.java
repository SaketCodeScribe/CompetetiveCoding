package com.dsa_algorithms.Greedy.RangeGreedy_IntervalCovering;

public class LC45 {
    public int jump(int[] nums) {
        int n = nums.length, jumps = 0, i, j = Math.min(nums[0], n-1), maxEnd = -1;
        if (n == 1){
            return 0;
        }

        for(i=0; i<n; i++){
            maxEnd = Math.max(maxEnd, Math.min(n-1, i+nums[i]));
            if (i == j){
                j = maxEnd;
                jumps++;
            }
        }
        return jumps;
    }
}
