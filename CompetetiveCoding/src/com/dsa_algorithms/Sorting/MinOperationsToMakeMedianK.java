package com.dsa_algorithms.Sorting;
import java.util.*;

public class MinOperationsToMakeMedianK {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        int i, n = nums.length , p = 1;
        long ans = 0;
        Arrays.sort(nums);
        i = n/2;
        if (k == nums[i])
            return ans;
        if (k > nums[i])
            p = 1;
        else if (k < nums[i])
            p = -1;
        while (i < n && i >= 0 && !((p > 0 && k <= nums[i]) || p < 0 && k >= nums[i])){
            ans += (long)Math.abs(nums[i]-k);
            i += p;
        }
        return ans;
    }
}
