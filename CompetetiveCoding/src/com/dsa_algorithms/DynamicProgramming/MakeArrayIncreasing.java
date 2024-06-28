package com.dsa_algorithms.DynamicProgramming;

import java.util.*;

/**
 * While submitting in leetcode, use Pair class of javafx.
 */
class Solution {
    static class Pair<T>{
        T a, b;
        public Pair(T a, T b){
            this.a = a;
            this.b = b;
        }
    }

    TreeSet<Integer> orderedSet;
    Map<Pair<Integer>, Integer> dp;
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int i = 0, n = arr1.length;
        orderedSet = new TreeSet<>();
        dp = new HashMap<>();

        for(int num:arr2)
            orderedSet.add(num);
        int ans = minMoves(0, -1, n, arr1);
        return ans < (int)1e9 ? ans : -1;
    }
    public int minMoves(int i, int prev, int n, int[] nums){
        if (i >= n)
            return 0;
        Pair<Integer> pair = new Pair<>(i, prev);
        if (dp.containsKey(pair))
            return dp.get(pair);
        int res;
        Integer elt = orderedSet.higher(prev);
        if (elt == null)
            res = (int)1e9;
        else
            res = minMoves(i+1, elt, n, nums)+1;
        if (nums[i] > prev)
            res = Math.min(res, minMoves(i+1, nums[i], n, nums));
        dp.put(pair, res);
        return res;
    }
}