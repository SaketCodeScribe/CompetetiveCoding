package com.dsa_algorithms.BinarySearch;

public class FindPivotinRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n-1, mid, ans = -1;
        while(low <= high){
            mid = (low+high)>>1;
            if (nums[mid] > nums[n-1]){
                low = mid+1;
                ans = mid;
            }
            else
                high = mid-1;
        }
        return nums[ans+1];
    }
}
