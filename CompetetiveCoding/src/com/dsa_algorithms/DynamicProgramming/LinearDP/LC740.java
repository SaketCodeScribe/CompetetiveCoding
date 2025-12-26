package com.dsa_algorithms.DynamicProgramming.LinearDP;

public class LC740 {
    int n;
    int[] buckets;
    public int deleteAndEarn(int[] nums) {
        int i, taken = 0, notTaken = 0;
        initialize(nums);

        for(i=0; i<=n; i++){
            int curr = notTaken + buckets[i];
            notTaken = Math.max(notTaken, taken);
            taken = curr;
        }
        return Math.max(taken, notTaken);
    }
    private void initialize(int[] nums){
        for(int num:nums){
            n = Math.max(n, num);
        }
        buckets = new int[n+1];
        for(int num:nums){
            buckets[num] += num;
        }
    }
}
