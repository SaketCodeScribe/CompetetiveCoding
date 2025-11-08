package com.dsa_algorithms.Contest.weekly.weekly460;

import java.util.Arrays;

public class Solution4 {
    public long maximumMedianSum(int[] nums) {
        long ans = 0;
        int n = nums.length;
        Arrays.sort(nums);

        int i = 0, j = nums.length-1;

        while(i < j-1){
            ans += nums[j-1];
            j -= 2;
            i++;
        }
        return ans;
    }
}
