package com.dsa_algorithms.Array;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k == 0)
            return;
        reverse(nums,0,n-1);
        reverse(nums,0, k-1);
        reverse(nums,k, n-1);
    }
    public void reverse(int[] nums, int i, int j){

        while(i<j){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++; j--;
        }
    }
}
