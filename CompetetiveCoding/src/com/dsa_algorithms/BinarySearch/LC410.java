package com.dsa_algorithms.BinarySearch;

public class LC410 {
    public int splitArray(int[] nums, int k) {
        int n = nums.length, ans = -1, low = 0, high = 0;

        for(int num:nums) {
            low = Math.max(low, num);
            high += num;
        }
        while(low <= high) {
            int mid = low + (high-low)/2;
            if (getBuckets(nums, mid) <= k) {
                ans = mid;
                high = mid-1;
            } else low = mid+1;
        }
        return ans;
    }

    private int getBuckets(int[] nums, int tar) {
        int cnt = 1, sum = 0;

        for(int num:nums) {
            sum += num;
            if (sum > tar) {
                cnt++;
                sum = num;
            }
        }
        return cnt;
    }
}
