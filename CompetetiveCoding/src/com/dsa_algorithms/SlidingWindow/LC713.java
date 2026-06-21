package com.dsa_algorithms.SlidingWindow;

public class LC713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, i = 0, j = 0, ans = 0;
        long prod = 1;

        while(j < n){
            prod *= nums[j];
            while(i <= j && prod >= k){
                prod /= nums[i++];
            }
            if (i <= j){
                int currWindow = j-i+1;
                ans += currWindow;
            }
            j++;
        }
        return ans;
    }
}
