package com.dsa_algorithms.Contest.weekly.weekly454;

import java.util.Arrays;

public class Solution3 {
    public long maximumProduct(int[] nums, int m) {
        int i, n = nums.length;
        long[] max = new long[n];
        long[] min = new long[n];
        Arrays.fill(max, Integer.MIN_VALUE);
        Arrays.fill(min, Integer.MAX_VALUE);
        long ans = Long.MIN_VALUE;
        max[0] = min[0] = nums[0];

        for(i=0; i<n; i++){
            if (i >= m-1){
                ans = Math.max(ans, Math.max(min[i-m+1]*nums[i], max[i-m+1]*nums[i]));
            }
            else if (i > 0){
                min[i] = Math.min(nums[i], min[i-1]);
                max[i] = Math.max(nums[i], max[i-1]);
            }
        }
        return ans;
    }
}
