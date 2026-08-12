package com.dsa_algorithms.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        init(map, nums);

        return permutations(map);
    }
    private void init(Map<Integer, Integer> map, int[] nums) {
        for(int num:nums) {
            map.compute(num, (key, value) -> {
                if (value == null) return 1;
                return value + 1;
            });
        }
    }
    private List<List<Integer>> permutations(Map<Integer, Integer> map) {
        List<List<Integer>> res = new ArrayList<>();
        int value;

        for(Integer key:map.keySet()) {
            value = map.get(key);
            if (value == 0) continue;
            map.put(key, value-1);
            for(List<Integer> permutation:permutations(map)) {
                permutation.add(key);
                res.add(permutation);
            }
            map.put(key, value);
        }
        if (res.isEmpty()) res.add(new ArrayList<>());
        return res;
    }
}
