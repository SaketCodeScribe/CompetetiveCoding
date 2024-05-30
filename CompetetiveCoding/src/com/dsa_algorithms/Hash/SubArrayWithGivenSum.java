package com.dsa_algorithms.Hash;

import java.util.*;

public class SubArrayWithGivenSum {
    public static int[] subarraySum(int[] arr, long sum) {
        // Write you code here.
        int i, n = arr.length;
        long curr = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0l,-1);
        for(i=0; i<n; i++){
            curr += arr[i];
            if (map.containsKey(curr-sum))
                return new int[]{map.get(curr-sum)+1, i};
            map.put(curr, i);
        }
        return new int[]{-1,-1};
    }
}
