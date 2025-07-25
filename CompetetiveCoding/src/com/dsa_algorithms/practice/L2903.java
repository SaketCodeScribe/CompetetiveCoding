package com.dsa_algorithms.practice;

import java.util.ArrayDeque;
import java.util.Deque;

public class L2903 {

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length, i, min = 0, max = 0;

        for(i=indexDifference; i<n; i++){
            if (nums[i-indexDifference] < nums[min]){
                min = i-indexDifference;
            }
            if (nums[i-indexDifference] > nums[max]){
                max = i-indexDifference;
            }
            if (Math.abs(nums[i] - nums[min]) >= valueDifference){
                return new int[]{min, i};
            }
            if (Math.abs(nums[i] - nums[max]) >= valueDifference){
                return new int[]{max, i};
            }
        }
        return new int[]{-1,-1};
    }
}
