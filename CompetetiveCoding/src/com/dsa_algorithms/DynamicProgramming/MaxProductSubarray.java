package com.dsa_algorithms.DynamicProgramming;

public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        int i, n = nums.length;
        double prod = 1, ans = Integer.MIN_VALUE;
        double[] right = new double[n+1];
        right[n] = 1;
        for(i=n-1; i>=0; i--){
            right[i] = right[i+1]*nums[i];
            if (right[i] == 0)
                right[i] = 1;
        }

        for(i=0; i<n; i++){
            if (nums[i] == 0)
                ans = Math.max(ans, nums[i]);
            else
                ans = Math.max(ans, Math.max(prod*nums[i], Math.max(right[i],prod*right[i])));
            prod *= nums[i];
            if (prod == 0)
                prod = 1;
        }
        return (int)ans;
    }
}
