package com.dsa_algorithms.practice;

import java.util.*;

public class L3350 {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int low = 1, mid, high = nums.size()/2, ans = 1;

        while(low <= high){
            mid = low+(high-low)/2;
            if (getIncArray(nums, mid)){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
    private boolean getIncArray(List<Integer> nums, int k){
        for(int i=0; i<=nums.size()-k; i++){
            int index = getRotationPoint(nums, i, i+k-1);
            if (index >= 0 && index-i == k/2){
                return true;
            }
        }
        return false;
    }
    private int getRotationPoint(List<Integer> nums, int low, int high){
        int s = low, e = high;
        int mid;

        while(low <= high){
            mid = low+(high-low)/2;
            if (nums.get(mid) == nums.get(low) || nums.get(mid) == high){
                return -1;
            }
            else if (nums.get(mid) < (mid > 0 ? nums.get(mid-1) : Integer.MAX_VALUE) &&
                    nums.get(mid) < (mid < nums.size()-1 ? nums.get(mid+1) : Integer.MAX_VALUE)){
                return mid;
            }
            else if (nums.get(mid) > Math.max(nums.get(s), nums.get(e))){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }

}
