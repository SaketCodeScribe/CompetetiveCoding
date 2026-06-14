package com.dsa_algorithms.SlidingWindow;

public class LC992 {
    public int subarraysWithKDistinct(int[] nums, int k){
        int bound = 0;
        for(int num:nums)
            bound = Math.max(num+1, bound);

        return (int)(findAtleastSubarrays(nums, nums.length, k, bound) - findAtleastSubarrays(nums, nums.length, k-1, bound));
    }
    private long findAtleastSubarrays(int[] nums, int n, int k, int bound){
        int i = 0, j = 0, unique = 0;
        long count = 0;
        int[] freq = new int[bound];

        while(j < n){
            freq[nums[j]]++;
            if (freq[nums[j]] == 1) unique++;
            while(i <= j && unique > k){
                freq[nums[i]]--;
                if (freq[nums[i++]] == 0) unique--;
            }
            count += j-i+1;
            j++;
        }
        return count;
    }
}
