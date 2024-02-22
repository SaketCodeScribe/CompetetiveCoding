package com.dsa_algorithms.Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SubsetSumll {
    List<List<Integer>> ans;
    List<Integer> vec;

    public static void main(String[] args) {
        SubsetSumll obj = new SubsetSumll();
        System.out.println(obj.subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(obj.subsetsWithDup(new int[]{0}));
        System.out.println(obj.subsetsWithDup(new int[]{1, 2, 2, 1, 3, -4, 6, 1, 2, 3}));
    }

    public void subsetsWithDup_(int[] nums) {
        ans = new ArrayList<>();
        vec = new ArrayList<>();
        System.out.println(subsetsWithDup_(0, vec, nums));


    }

    List<List<Integer>> subsetsWithDup_(int start, List<Integer> vec, int[] nums) {
        ans.add(new ArrayList<>(vec));
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i] != nums[i - 1]) {
                vec.add(nums[i]);
                subsetsWithDup_(i + 1, vec, nums);
                vec.remove(vec.size() - 1);
            }
        }
        return ans;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int i, j, n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        for (i = 0; i < (int) Math.pow(2, n); i++) {
            List<Integer> temp = new ArrayList<>();
            for (j = 0; j < n; j++) {
                if (isSetBit(i, j))
                    temp.add(nums[j]);
            }
            ans.add(temp);
        }
        return ans.stream().collect(Collectors.toList());
    }

    private boolean isSetBit(int i, int j) {
        return (i & (1 << j)) > 0;
    }
}
