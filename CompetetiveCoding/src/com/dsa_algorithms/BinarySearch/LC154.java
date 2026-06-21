package com.dsa_algorithms.BinarySearch;

public class LC154 {
    public int findMin(int[] nums) {
        int n = nums.length, i = 0, j = n-1;

        while(i < j){
            int mid = i + (j-i)/2;
            if (i < mid && nums[i] == nums[mid]){
                while(i < mid && nums[i] == nums[mid]) i++;
                continue;
            }
            if (j > mid && nums[j] == nums[mid]){
                while(j > mid && nums[j] == nums[mid]) j--;
                continue;
            }
            if (nums[i] > nums[mid] || nums[j] > nums[mid]) j = mid;
            else i = mid+1;
        }
        return nums[i];
    }
}
