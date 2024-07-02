package com.dsa_algorithms.BinarySearch;

public class SearchInRotatedSortedArrayWithDuplicates {
    public boolean search(int[] nums, int target) {
        int low, high, n = nums.length, mid;
        low = 0; high = n-1;

        while(low <= high){
            mid = (low+high)>>1;
            if (nums[mid] == target)
                return true;
            int left = low, right = high;
            while(left < mid && nums[left] == nums[mid])
                left++;
            while(right > mid && nums[right] == nums[mid])
                right--;
            if (nums[mid] >= nums[left]){
                if (nums[left] <= target && nums[mid] > target){
                    high = mid-1;
                    low = left;
                }
                else
                    low = mid+1;
            }
            else{
                if (nums[mid] < target && nums[right] >= target){
                    low = mid+1;
                    high = right;
                }
                else
                    high = mid-1;
            }
        }
        return false;
    }
}
