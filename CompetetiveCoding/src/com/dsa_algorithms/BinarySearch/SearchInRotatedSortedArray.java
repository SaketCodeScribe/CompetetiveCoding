package com.dsa_algorithms.BinarySearch;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length, low = 0, high, mid;
        high = n-1;

        while(low <= high){
            mid = (low+high) >> 1;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] >= nums[low]){
                if (nums[low] <= target && target < nums[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
            else{
                if (nums[high] >= target && target > nums[mid])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }
}
