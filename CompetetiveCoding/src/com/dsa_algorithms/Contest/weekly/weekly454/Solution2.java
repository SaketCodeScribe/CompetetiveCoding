package com.dsa_algorithms.Contest.weekly.weekly454;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    private static final int MOD = 1_000_000_007;
    public static int specialTriplets(int[] nums) {
        int i, n = nums.length;
        long[] lfreq = new long[2_00_002], rfreq = new long[2_00_002];
        long ans = 0;

        for(i=0; i<n; i++){
            rfreq[nums[i]]++;
        }
        lfreq[nums[0]]++;
        rfreq[nums[0]]--;
        for(i=1; i<n-1; i++){
            rfreq[nums[i]]--;
            int doubleVal = nums[i] * 2;
            ans = (ans + lfreq[doubleVal]*rfreq[doubleVal])%MOD;
            lfreq[nums[i]]++;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(specialTriplets(new int[]{8,4,8,2,4}));
    }
}
