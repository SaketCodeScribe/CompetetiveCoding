package com.dsa_algorithms.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);
        uniqueCombinations(candidates, ans, target, 0, candidates.length, new ArrayList<>());
        return ans;
    }

    private void uniqueCombinations(int[] candidates, List<List<Integer>> ans, int target, int begin, int n, List<Integer> aux) {
        if (target == 0) {
            ans.add(new ArrayList<>(aux));
            return;
        }
        if (target < 0 || begin >= n) return;

        int i = begin;
        while(i < n && target >= candidates[i]) {
            if (i > begin && candidates[i] == candidates[i-1]) i++;
            else {
                aux.add(candidates[i]);
                uniqueCombinations(candidates, ans, target - candidates[i], i + 1, n, aux);
                aux.remove(aux.size()-1);
                i++;
            }
        }
    }
}