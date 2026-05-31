package com.dsa_algorithms.SlidingWindow;

public class LC2461 {
    static class Sum{
        long value;
        public void add(int num){ value += num;}
        public void minus(int num){ value -= num;}
        public long get(){return value;}
    }
    public long maximumSubarraySum(int[] nums, int k) {
        int i = 0, j = 0, n = nums.length;
        long ans = 0;
        Sum sum = new Sum();

        boolean[] freq = new boolean[100_001];
        /**
         1. duplicate element
         2. more than k unique elements
         */
        while(j < n){
            i = slideIfDuplicate(nums, freq, sum, i, j);
            freq[nums[j]] = true;
            sum.add(nums[j]);
            if (j - i == k){
                sum.minus(nums[i]);
                freq[nums[i++]] = false;
            }
            if (j-i == k-1){
                ans = Math.max(ans, sum.get());
            }
            j++;
        }
        return ans;
    }
    private int slideIfDuplicate(int[] nums, boolean[] freq, Sum sum, int i, int j){
        if (!freq[nums[j]]){
            return i;
        }
        do{
            sum.minus(nums[i]);
            freq[nums[i++]] = false;
        }
        while(i < j && freq[nums[j]]);
        return i;
    }
}
