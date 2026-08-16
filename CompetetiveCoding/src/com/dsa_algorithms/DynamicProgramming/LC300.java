package com.dsa_algorithms.DynamicProgramming;

public class LC300 {
    public int lengthOfLIS(int[] nums) {
        int size = 0;
        int[] lis = new int[nums.length];


        for(int num:nums) {
            int index = getPosition(lis, size, num);
            if (index >= size) size++;
            lis[index] = num;
        }
        return size;
    }
    private int getPosition(int[] lis, int n, int target) {
        int lo = 0, hi = n-1, mid;

        while(lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (lis[mid] == target) return mid;
            if (lis[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }
}
