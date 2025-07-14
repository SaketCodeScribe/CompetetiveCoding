package com.dsa_algorithms.SegmentTree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution3 {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            ans.add(0);
        }
        List<List<Integer>> arr = IntStream.range(0, n).boxed().map(i -> List.of(nums[i], i)).collect(Collectors.toList());
        mergeSort(arr, 0, n-1, ans);
        return ans;
    }
    private void mergeSort(List<List<Integer>> arr, int low, int high, List<Integer> ans){
        if (low >= high){
            return;
        }
        int mid = low+(high-low)/2;
        mergeSort(arr, low, mid, ans);
        mergeSort(arr, mid+1, high, ans);
        merge(arr, low, mid, mid+1, high, ans);
    }
    private void merge(List<List<Integer>> arr, int s1, int e1, int s2, int e2, List<Integer> ans){
        if (s1 > e1 || s2 > e2){
            return;
        }
        int i, j;
        List<List<Integer>> left = new ArrayList<>();
        List<List<Integer>> right = new ArrayList<>();
        for(i=s1; i<=e1; i++){
            left.add(arr.get(i));
        }
        for(i=s2; i<=e2; i++){
            right.add(arr.get(i));
        }
        i = s1; j = s2;
        int p = s1;
        while(i <=e1 || j<= e2){
            if (i <= e1){
                int k = left.get(i-s1).get(1);
                ans.set(k, ans.get(k)+j-s2);
            }
            if (i > e1){
                arr.set(p++, right.get(j-s2));
                j++;
            }
            else if (j >  e2){
                arr.set(p++, left.get(i-s1));
                i++;
            }
            else if (left.get(i-s1).get(0) <= right.get(j-s2).get(0)){
                arr.set(p++, left.get(i-s1));
                i++;
            }
            else{
                arr.set(p++, right.get(j-s2));
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Solution3 obj = new Solution3();
        System.out.println(obj.countSmaller(new int[]{5, 2, 6, 1}));
    }
}
