package com.dsa_algorithms;

import java.util.*;

public class Solution {
    static ArrayList<ArrayList<Integer>> ans;
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] input = new int[]{10,1,2,7,6,1,5};
        for(int a:input)
            arr.add(a);
        System.out.println(combinationSum2(arr, arr.size(), 8));
    }
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target)    {
        ArrayList<Integer> collect = new ArrayList<>();
        ans = new ArrayList<>();
        arr.sort(Integer::compareTo);
        findUniqueCombination(0, arr, collect, n, target);
        return ans;
    }
    static void findUniqueCombination(int start, ArrayList<Integer> arr, ArrayList<Integer> collect, int n, int target){
        int i;
        if (target == 0){
            ans.add(new ArrayList<>(collect));
            return;
        }
        for(i=start; i<n; i++){
            if (i  > start && arr.get(i) == arr.get(i-1))
                continue;
            if (arr.get(i) <= target){
                collect.add(arr.get(i));
                findUniqueCombination(i+1, arr, collect, n, target-arr.get(i));
                collect.remove(collect.size()-1);
            }
        }
    }
}