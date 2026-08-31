package com.dsa_algorithms.Greedy;

import java.util.Arrays;

public class LC1838 {
    public int maxFrequency(int[] nums, int k) {
        int left=0, right=0, n = nums.length, ans = 0;
        long sum = 0;

        Arrays.sort(nums);

        while(right < n) {
            sum += nums[right];
            while((long)(right - left + 1) * nums[right] - sum > k){
                sum -= nums[left++];
            }
            ans = Math.max(ans, ++right-left);
        }
        return ans;
    }
}
