package com.dsa_algorithms.BinarySearch.Maximize_or_minimize_to_achieve_target;

public class MinimumLimitOfBallsInaBag {
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1, high = (int)1e9, mid, ans = 1;

        while(low <= high){
            mid = (low+high) >> 1;
            int op = findOperations(nums, mid);
            if (op <= maxOperations){
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return ans;
    }
    public int findOperations(int[] nums, int tar){
        int ops = 0;
        for(int num:nums)
            ops += (num-1)/tar;
        return ops;
    }
}
