package com.dsa_algorithms.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    int n;
    List<Integer> temp;
    List<List<Integer>> ans;

    public static void main(String[] args) {
        CombinationSumII obj = new CombinationSumII();
        System.out.println(obj.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(obj.combinationSum2(new int[]{10, 10, 2, 70, 60, 10, 50}, 8));
        System.out.println(obj.combinationSum2(new int[]{1,1}, 1));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        temp = new ArrayList<>();
        ans = new ArrayList<>();
        n = candidates.length;
        Arrays.sort(candidates);
        fecthAllCombinationSum(0, 0, target, candidates);
        return ans;
    }

    private void fecthAllCombinationSum(int start, int sum, int target, int[] candidates) {
        if (sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (start >= n)
            return;
        int i = start;

        while (i < n) {
            while (i > start && i < n && candidates[i] == candidates[i - 1])
                i++;
            if (i < n && sum + candidates[i] <= target) {
                temp.add(candidates[i]);
                fecthAllCombinationSum(i + 1, sum + candidates[i], target, candidates);
                temp.remove(temp.size() - 1);
            }
            i++;
        }
    }
}
