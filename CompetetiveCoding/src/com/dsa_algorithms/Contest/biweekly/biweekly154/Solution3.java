package com.dsa_algorithms.Contest.biweekly.biweekly154;

import java.util.*;

public class Solution3 {

    public int uniqueXorTriplets(int[] nums) {
        int i, j, n = nums.length;
        boolean[] buckets = new boolean[2048];

        for(i=0; i<n; i++){
            for(j=0; j<n; j++){
                buckets[(nums[i]^nums[j])] = true;
            }
        }
        Set<Integer> set = new HashSet<>();
        for(i=0; i<2048; i++){
            for(j=0; j<n; j++) {
                if (buckets[i]) {
                    set.add(i ^ nums[j]);
                }
            }
        }
        return set.size();
    }
}
