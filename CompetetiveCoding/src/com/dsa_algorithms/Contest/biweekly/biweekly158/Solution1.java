package com.dsa_algorithms.Contest.biweekly.biweekly158;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 obj = new Solution1();
    }
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int i, n = x.length;
        int max1 = -1, max2 = -1, max3 = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for(i=0; i<n; i++){
            map.put(x[i], Math.max(map.getOrDefault(x[i], 0), y[i]));
            if (map.get(x[i]) < y[i]){
                map.put(x[i], y[i]);
            }
        }
        for(Integer val:map.values()){
            if (val > max1){
                max3 = max2;
                max2 = max1;
                max1 = val;
            }
            else if (val > max2){
                max3 = max2;
                max2 = val;
            }
            else if (val > max3){
                max3 = val;
            }
        }
        if (max1 == -1 || max2 == -1 || max3 == -1){
            return -1;
        }
        return max1+max2+max3;
    }
}
