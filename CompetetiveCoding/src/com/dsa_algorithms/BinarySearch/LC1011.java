package com.dsa_algorithms.BinarySearch;

public class LC1011 {
    public int shipWithinDays(int[] weights, int days) {
        long[] init = getBound(weights);
        long low = init[0], high = init[1], ans = 0, mid;

        while(low <= high){
            mid = low + (high-low)/2;

            if (noOfDaysToShip(weights, mid) <= days){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return (int)ans;
    }
    private long[] getBound(int[] nums){
        long sum = 0, max = 0;
        for(int num:nums){
            sum += num;
            max = Math.max(max, num);
        }
        return new long[]{max, sum};
    }
    private long noOfDaysToShip(int[] weights, long w){
        long days = 1, wt = 0;
        for(int weight:weights){
            if (wt + weight > w) {
                wt = 0;
                days++;
            }
            wt += weight;
        }
        return days;
    }
}
