package com.dsa_algorithms.Hash;

import java.util.HashSet;
import java.util.Set;

public class LC128 {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        Set<Integer> set = new HashSet<>();

        for(int num:nums) {
            set.add(num);
        }
        for(int num:nums) {
            if (!set.contains(num-1)){
                int x = num, cnt = 0;
                while(set.contains(x)) {
                    set.remove(x);
                    x++;
                    cnt++;
                }
                maxLen = Math.max(cnt, maxLen);
            }
        }
        return maxLen;
    }
}
