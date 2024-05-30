package com.dsa_algorithms.Kadane;

public class MaximumSubarraySum {
    public static long maxSubarraySum(int[] arr, int n) {
        long sum = 0, maxSum = 0;

        for(int val:arr){
            sum += val;
            maxSum = Math.max(maxSum, sum);
            if (sum < 0)
                sum = 0;
        }
        return maxSum;
    }
}
