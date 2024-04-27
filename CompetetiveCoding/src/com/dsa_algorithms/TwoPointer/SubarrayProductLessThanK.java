package com.dsa_algorithms.TwoPointer;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2)
            return 0;
        int i, j, n = nums.length, prod = 1, ans = 0;
        i = j = 0;

        while(j < n){
            while(j < n){
                if(prod*nums[j] >= k){
                    if (i == j){
                        j++;
                        i++;
                    }
                    break;
                }
                prod *= nums[j++];
                ans += j-i;
            }
            while(i < j && j < n){
                if(prod*nums[j] < k)
                    break;
                prod /= nums[i++];
            }
        }
        return ans;
    }
}
