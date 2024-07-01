package com.dsa_algorithms.Hash;

import java.util.*;
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int i, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(i=0; i<n; i++){
            if (map.containsKey(target-nums[i]))
                break;
            map.putIfAbsent(nums[i], i);
        }
        return new int[]{map.get(target-nums[i]), i};
    }
}
