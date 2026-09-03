package com.dsa_algorithms.Hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersection(nums2, nums1);
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for(int num:nums2) {
            set.add(num);
        }
        for(int num:nums1) {
            if (set.contains(num)) {
                ans.add(num);
                set.remove(num);
            }
        }
        return ans.stream().mapToInt(x -> x).toArray();
    }
}
