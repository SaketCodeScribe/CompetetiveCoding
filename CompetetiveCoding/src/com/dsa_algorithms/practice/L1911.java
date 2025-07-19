package com.dsa_algorithms.practice;

public class L1911 {
    public long maxAlternatingSum(int[] nums) {
        int i, n = nums.length;
        long oddParitySum = 0, evenParitySum = 0;
        evenParitySum = nums[0];

        for(i=1; i<n; i++){
            long temp = evenParitySum;
            evenParitySum = Math.max(evenParitySum, Math.max(nums[i], oddParitySum+nums[i]));
            oddParitySum = Math.max(oddParitySum, temp-nums[i]);
        }
        return Math.max(oddParitySum, evenParitySum);
    }
}
