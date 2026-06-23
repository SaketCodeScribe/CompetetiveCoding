package com.dsa_algorithms.TwoPointer;

public class LC875 {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = getBound(piles), ans = 0;

        while(low <= high){
            int mid = low + (high-low)/2;

            if (noOfHoursToEat(piles, mid) <= h){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
    private int getBound(int[] nums){
        int max = 0;
        for(int num:nums){
            max = Math.max(num, max);
        }
        return max;
    }
    private long noOfHoursToEat(int[] piles, long k){
        long time = 0;
        for(int pile:piles){
            time += (pile + k - 1)/k;
        }
        return time;
    }
}
