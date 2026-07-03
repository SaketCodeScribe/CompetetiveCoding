package com.dsa_algorithms.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class LC523 {
    public boolean checkSubarraySum(int[] nums, int k) {
    int i, n = nums.length, sum = 0;

    Map<Integer, Integer> map = new HashMap<>();
    map.put(sum, -1);

    for(i=0; i<n; i++){
        sum += nums[i];
        sum %= k;
        Integer prev = map.putIfAbsent(sum, i);
        if (prev != null && i-prev > 1) return true;
    }
    return false;
}
}
