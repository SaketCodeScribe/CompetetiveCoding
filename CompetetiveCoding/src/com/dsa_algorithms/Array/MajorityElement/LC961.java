package com.dsa_algorithms.Array.MajorityElement;

public class LC961 {
    public int repeatedNTimes(int[] nums) {
        int i, n = nums.length;
        for(i=2; i<n; i++){
            if (nums[i] == nums[i-1] || nums[i] == nums[i-2]){
                return nums[i];
            }
        }
        return n == 4 ? nums[0] : -1;
    }
}
