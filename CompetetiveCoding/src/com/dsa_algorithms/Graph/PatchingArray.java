package com.dsa_algorithms.Graph;

public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int i = 0, ans = 0, len = nums.length;

        while(miss <= n){
            if (i < len && nums[i] <= miss)
                miss += nums[i++];
            else{
                miss += miss;
                ans++;
            }
        }
        return ans;
    }
}
