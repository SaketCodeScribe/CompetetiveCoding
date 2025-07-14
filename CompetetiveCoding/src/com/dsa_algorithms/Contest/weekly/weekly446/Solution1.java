package com.dsa_algorithms.Contest.weekly.weekly446;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(maximumPossibleSize(new int[]{4,2,5,3,5}));
    }
    public static int maximumPossibleSize(int[] nums) {
        int i, n = nums.length, ans = 0, max = -1;

        for(i=0; i<n-1; i++){
            max = nums[i];
            if (nums[i] > nums[i+1]){
                break;
            }
        }
        ans = ++i;
        for(; i<n; i++){
            if (nums[i] >= max){
                ans++;
            }
        }
        return ans;
    }
}
