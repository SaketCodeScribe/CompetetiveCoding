package com.dsa_algorithms.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0, n = nums.length;

        while(i<n){
            while(i > 0 && i < n && nums[i] == nums[i-1]) i++;
            int j = i+1, k = n-1;
            while(j < k){
                if (nums[j] + nums[k] < -nums[i]) j++;
                else if (nums[j] + nums[k] > -nums[i]) k--;
                else {
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    k--;
                    while(k > j && nums[k] == nums[k+1]) k--;
                }

            }
            i++;
        }
        return ans;
    }
}
