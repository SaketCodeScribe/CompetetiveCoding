package com.dsa_algorithms.DynamicProgramming.LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.List;

public class LC300 {
    public int lengthOfLIS(int[] nums) {
        int i, n = nums.length;
        List<Integer> list = new ArrayList<>();

        for(i=0; i<n; i++){
            int j = ceil(list, nums[i]);
            if (j >= list.size()){
                list.add(nums[i]);
            }
            else{
                list.set(j, nums[i]);
            }
        }
        return list.size();
    }
    private int ceil(List<Integer> list, int tar){
        int low = 0, high = list.size()-1, mid, ans = high+1;

        while(low <= high){
            mid = low + ((high - low)>>1);
            if (list.get(mid) >= tar){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}
