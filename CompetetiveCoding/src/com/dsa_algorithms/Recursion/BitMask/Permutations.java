package com.dsa_algorithms.Recursion.BitMask;

import java.util.*;
public class Permutations {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        allPossible(new ArrayList<>(), 0, nums.length, nums);
        return ans;
    }
    public void allPossible(List<Integer> temp, int bitMask, int n, int[] nums){
        if (bitMask == (1<<n)-1){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<n; i++){
            if ((bitMask & (1<<i)) == 0){
                temp.add(nums[i]);
                allPossible(temp, bitMask | (1<<i), n, nums);
                temp.remove(temp.size()-1);
            }
        }
    }
}
