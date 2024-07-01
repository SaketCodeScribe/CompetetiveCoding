package com.dsa_algorithms.Graph;

import java.util.*;
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int i, n = nums.length, ans = 0;
        Map<Integer, Boolean> map = new HashMap<>();

        for(i=0; i<n; i++)
            map.put(nums[i], true);

        for(int num:nums){
            if (map.containsKey(num+1))
                continue;
            int key = num;
            while(map.containsKey(key))
                key--;
            ans = Math.max(ans, num-key);
        }
        return ans;
    }
}
