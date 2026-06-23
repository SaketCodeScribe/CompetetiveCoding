package com.dsa_algorithms.TwoPointer;

public class LC2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int i = 0, j = 0, n = nums.length;
        int minIndex = -1, maxIndex = -1;
        long ans = 0;

        while(j < n){
            if (nums[j] < minK || nums[j] > maxK){
                minIndex = maxIndex = -1;
                i = ++j;
                continue;
            }
            if (nums[j] == minK) minIndex = j;
            if (nums[j] == maxK) maxIndex = j;
            if (minIndex != -1 && maxIndex != -1){
                ans += Math.min(minIndex, maxIndex) - i + 1;
            }
            j++;
        }
        return ans;
    }
}
