package com.dsa_algorithms.Contest.weekly.weekly452;

import java.util.*;
import java.util.Arrays;

public class Solution1 {
    public boolean checkEqualPartitions(int[] nums, long target) {
        int i, j, n = nums.length, cnt = 0;
        boolean flag = false;
        long prod = 1;
        List<Integer> list = new ArrayList<>();
        for(int num:nums){
            prod *= (long)num;
            if (num > 1){
                list.add(num);
            }
            else{
                cnt++;
            }
        }
        if (prod != target*target){
            return false;
        }
        if ((target == 1 && cnt == n)){
            return true;
        }
        Map<Integer, Integer> tarMap = new HashMap<>();
        extracted(target, tarMap);
        Map<Integer, Integer> factor = new HashMap<>();
        return check(list, tarMap, list.size(), 0, factor);
    }

    private static void extracted(long sqrt, Map<Integer, Integer> tarMap) {
        int i;
        for(i=2; i<= sqrt; i++){
            while(sqrt % i == 0){
                tarMap.put(i, tarMap.getOrDefault(i, 0)+1);
                sqrt /= i;
            }
        }
    }

    private boolean check(List<Integer> list, Map<Integer, Integer> tarMap, int n, int i, Map<Integer, Integer> factor){
        if (i == n){
            for(int key: tarMap.keySet()){
                if (factor.getOrDefault(key, 0) != tarMap.get(key)){
                    return false;
                }
            }
            return true;
        }
        boolean result = check(list, tarMap, n, i+1, factor);
        if (result){
            return true;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.putAll(factor);
        extracted(list.get(i), map);
        return check(list, tarMap, n, i+1, map);
    }
}
