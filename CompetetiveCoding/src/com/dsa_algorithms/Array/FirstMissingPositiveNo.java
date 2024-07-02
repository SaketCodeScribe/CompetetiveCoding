package com.dsa_algorithms.Array;

public class FirstMissingPositiveNo {
    public int firstMissingPositive(int[] nums) {
        int i, n = nums.length;

        for(i=0; i<n; i++){
            if (nums[i] <= 0 || nums[i] > n)
                nums[i] = n+1;
        }
        for(i=0; i<n; i++){
            if (Math.abs(nums[i]) <= n)
                nums[Math.abs(nums[i])-1] = -1*Math.abs(nums[Math.abs(nums[i])-1]);
        }
        for(i=1; i<=n; i++)
            if (nums[i-1] > 0)
                return i;
        return n+1;
    }
}
