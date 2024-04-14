package com.dsa_algorithms.Simulation;

public class DistributeElementsIntoTwoArraysI {
    public int[] resultArray(int[] nums) {
        int n = nums.length, i, j, k;
        int[] ans = new int[n];
        ans[0] = nums[0];
        nums[0] = -1;
        j = 0;
        k = 1;
        for(i=2; i<n; i++){
            if (ans[j] > nums[k]){
                ans[++j] = nums[i];
                nums[i] = -1;
            }
            else
                k = i;
        }
        for(i=1; i<n; i++){
            if (nums[i] >= 0)
                ans[++j] = nums[i];
        }
        return ans;
    }
}
