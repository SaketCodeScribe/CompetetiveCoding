package com.dsa_algorithms.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC756 {
    //1. T.C  - O(b^(h^2)). It also has a dp solution, b is unique no of characters
    //2. S.C - O(h^2) is recursion depth(stack depth), h  is ht
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();

        for(String s:allowed){
            map.computeIfAbsent(""+s.charAt(0)+s.charAt(1), x -> new ArrayList<>()).add(s.charAt(2));
        }
        return createPyramid(bottom, "", 0, bottom.length(), map);
    }
    private boolean createPyramid(String base, String newBase, int start, int n, Map<String, List<Character>> map){
        int i;
        if (n == 1){
            return true;
        }
        if (start == n-1){
            return createPyramid(newBase, "", 0, newBase.length(), map);
        }
        String key = ""+base.charAt(start)+base.charAt(start+1);
        if (!map.containsKey(key)){
            return false;
        }
        for(Character ch:map.get(key)){
            if (createPyramid(base, newBase+ch, start+1, n, map)){
                return true;
            }
        }
        return false;
    }
}
