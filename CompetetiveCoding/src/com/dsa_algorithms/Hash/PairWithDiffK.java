package com.dsa_algorithms.Hash;

import java.util.*;
public class PairWithDiffK {
    public static int getPairsWithDifferenceK(int arr[], int k) {
        //Write your code here
        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int num:arr){
            if (map.containsKey(num-k))
                ans += map.get(num-k);
            if (k > 0 && map.containsKey(num+k))
                ans += map.get(num+k);
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        return ans;
    }
}
