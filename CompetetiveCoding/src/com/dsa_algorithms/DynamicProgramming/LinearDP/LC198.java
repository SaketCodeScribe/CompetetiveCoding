package com.dsa_algorithms.DynamicProgramming.LinearDP;

public class LC198 {
    public int rob(int[] nums) {
        int maxAmtIncPrev = 0, maxAmtExcPrev = 0, maxAmt = 0, n = nums.length, i;

        for(i=0; i<n; i++){
            int curr = maxAmtExcPrev + nums[i];
            maxAmtExcPrev = Math.max(maxAmtExcPrev, maxAmtIncPrev);
            maxAmtIncPrev = curr;
        }
        return Math.max(maxAmtIncPrev, maxAmtExcPrev);
    }
}
