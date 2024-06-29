package com.dsa_algorithms.Set;

import java.util.*;
public class DiffOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(getElements(nums1, nums2), getElements(nums2, nums1));
    }
    public List<Integer> getElements(int[] a, int[] b){
        Set<Integer> set = new HashSet<>(), res = new HashSet<>();
        for(int num:b)
            set.add(num);
        for(int num:a){
            if (!set.contains(num))
                res.add(num);
        }
        return new ArrayList<>(res);
    }
}
