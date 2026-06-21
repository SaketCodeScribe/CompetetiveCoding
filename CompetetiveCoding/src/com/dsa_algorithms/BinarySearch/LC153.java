package com.dsa_algorithms.BinarySearch;

public class LC153 {
    public int findMin(int[] nums) {
        int n = nums.length, i = 0, j = n-1;

        while(i < j){
            int mid = i + (j-i)/2;
            if (nums[i] > nums[mid] || nums[j] > nums[mid]){
                j = mid;
            }
            else i = mid+1;
        }
        return nums[i];
    }
}
