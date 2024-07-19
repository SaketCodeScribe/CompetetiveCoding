package com.dsa_algorithms.Array.PrefixSum;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int cntZeroes = 0, i, n = nums.length;
        long prod = 1;
        for(int num:nums){
            if (num != 0)
                prod *= num;
            else
                cntZeroes++;
        }
        for (i=0; i<n; i++)
            nums[i] = nums[i] != 0 ? (cntZeroes > 0 ? 0 : (int)(prod/nums[i])): (cntZeroes > 1 ? 0 : (int) prod);
        return nums;
    }
}
