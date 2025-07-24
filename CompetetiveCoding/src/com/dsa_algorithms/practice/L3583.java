package com.dsa_algorithms.practice;

import java.util.Arrays;

public class L3583 {
    private final int MOD = 1_000_000_007;
    public int specialTriplets(int[] nums) {
        int i, n = nums.length, max = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        long[] left = new long[max+1], right = new long[max+1];

        for(int num:nums){
            left[num]++;
        }
        for(i=n-1; i>=0; i--){
            if (nums[i] > 0 && nums[i]*2 <= max){
                ans = (ans + (left[nums[i]*2]*right[nums[i]*2])%MOD)%MOD;
            }
            else if (nums[i] == 0){
                ans = (ans + ((left[0]-1)*right[0])%MOD)%MOD;
            }
            right[nums[i]]++;
            left[nums[i]]--;
        }
        return (int)ans;
    }
}
