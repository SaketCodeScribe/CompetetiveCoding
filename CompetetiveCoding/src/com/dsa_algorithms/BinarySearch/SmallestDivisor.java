package com.dsa_algorithms.BinarySearch;

import java.util.Arrays;

public class SmallestDivisor {
    public int smallestDivisor(int[] nums, int threshold) {
        int mid, lo = 1, hi = Arrays.stream(nums).max().getAsInt(), sum;

        while (lo < hi){
            mid = lo+(hi-lo)/2;
            sum = findSum(nums, mid);
            System.out.println(lo+" "+hi+" "+mid+": "+sum);
            if (sum <= threshold)
                hi = mid;
            else
                lo = mid+1;
        }
        return hi;
    }

    private int findSum(int[] nums, int mid) {
        int sum = 0;
        for(int num:nums){
            sum += num/mid;
            if (num%mid != 0)
                sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        SmallestDivisor obj = new SmallestDivisor();
        System.out.println(obj.smallestDivisor(new int[]{2,3,5,7,11}, 11));
    }
}
