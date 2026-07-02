package com.dsa_algorithms.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class LC560 {
    public int subArraySum(int[] nums, int k) {
        int i, n = nums.length, ans = 0;
        long sum = 0;
        Map<Long, Integer> count = new HashMap<>();
        count.put(0L, 1);

        for(int num:nums){
            sum += num;
            ans += count.getOrDefault(sum - k, 0);
            count.compute(sum, (key,value) -> value == null ? 1 : value+1);
        }
        return ans;
    }
}
