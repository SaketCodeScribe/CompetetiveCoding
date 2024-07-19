package com.dsa_algorithms.TwoPointer.Simulation;

public class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        int i = 0, j = 1, n = nums.length;
        int[] ans = new int[n];

        for(int num:nums){
            if(num > 0){
                ans[i] = num;
                i += 2;
            }
            else{
                ans[j] = num;
                j += 2;
            }
        }
        return ans;
    }
}
