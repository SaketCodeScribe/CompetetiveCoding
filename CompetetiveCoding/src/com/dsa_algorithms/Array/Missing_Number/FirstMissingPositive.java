package com.dsa_algorithms.Array.Missing_Number;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int i, n = nums.length;

        for(i=0; i<n; i++)
            nums[i] = (nums[i] <= 0 || nums[i] > n) ? n+1 : nums[i];

        for(i=0; i<n; i++){
            if (Math.abs(nums[i]) <= n)
                nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);
        }
        for(i=0; i<n; i++)
            if (nums[i] > 0)
                return i+1;
        return n+1;
    }
}
