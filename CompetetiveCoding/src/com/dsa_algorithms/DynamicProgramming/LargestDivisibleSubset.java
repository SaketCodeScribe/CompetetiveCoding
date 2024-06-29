package com.dsa_algorithms.DynamicProgramming;

import java.util.*;
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int i, j, n = nums.length, len = 0, id = -1;
        List<Integer> ans = new ArrayList<>();
        int[] dp = new int[n+1];
        Arrays.sort(nums);

        for(i=1; i<=n; i++){
            for(j=i; j > 0; j--){
                if (i == j)
                    dp[i] = 1;
                else if (nums[i-1]%nums[j-1] == 0)
                    dp[i] = Math.max(dp[i], dp[j]+1);
                if (len < dp[i]){
                    len = dp[i];
                    id = i-1;
                }
            }
        }
        if (id == -1)
            return ans;
        j = id;
        ans.add(nums[j--]);
        while (j >= 0){
            if (dp[j+1] == len-1 && nums[id] % nums[j] == 0){
                ans.add(nums[j]);
                len--;
                id = j;
            }
            j--;
        }
        return ans;
    }
}
