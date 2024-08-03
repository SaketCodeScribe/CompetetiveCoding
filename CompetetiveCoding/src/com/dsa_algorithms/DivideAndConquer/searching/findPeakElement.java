package com.dsa_algorithms.DivideAndConquer.searching;

public class findPeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0, mid, high = nums.length-1, n = nums.length;

        while(low <= high){
            mid = (low+high)>>1;
            if ((mid == 0 || nums[mid] > nums[mid-1]) && (mid == n-1 || nums[mid] > nums[mid+1]))
                return mid;
            if ((mid == 0 || nums[mid] > nums[mid-1]))
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
}
