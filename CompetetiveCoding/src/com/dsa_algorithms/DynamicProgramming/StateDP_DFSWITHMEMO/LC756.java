package com.dsa_algorithms.DynamicProgramming.StateDP_DFSWITHMEMO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC756 {
    //1. T.C - O(b^h) - no.of states * work per state. no of states = no of bases formed = for any i b^(h-i-1) = summation over i = b^h
    // work per state = O(1). Hence, O(b^h)
    //2. S.C - O(h^2) recursion depth(stack calls). h is ht, b is unique characters
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        Map<String, Boolean> dp = new HashMap<>();

        for(String s:allowed){
            map.computeIfAbsent(""+s.charAt(0)+s.charAt(1), x -> new ArrayList<>()).add(s.charAt(2));
        }
        return createPyramid(bottom, "", 0, bottom.length(), map, dp);
    }
    private boolean createPyramid(String base, String newBase, int start, int n, Map<String, List<Character>> map, Map<String, Boolean> dp){
        int i;
        if (n == 1){
            return true;
        }
        if (newBase.isEmpty() && dp.containsKey(base)){
            return dp.get(base);
        }
        if (start == n-1){
            boolean result = createPyramid(newBase, "", 0, newBase.length(), map, dp);
            dp.put(base, result);
            return result;
        }
        String key = ""+base.charAt(start)+base.charAt(start+1);
        if (!map.containsKey(key)){
            return false;
        }

        for(Character ch:map.get(key)){
            if (createPyramid(base, newBase+ch, start+1, n, map, dp)){
                return true;
            }
        }
        return false;
    }
}
