package com.dsa_algorithms.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class LC525 {
    public int findMaxLength(int[] nums) {
        int i, sum = 0, n = nums.length, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(i=0; i<n; i++){
            int num = nums[i];
            sum += num == 0 ? -1 : 1;
            Integer prev = map.putIfAbsent(sum, i);
            if (prev != null && i-prev > ans){
                ans = i-prev;
            }
        }
        return ans;
    }
}
