package com.dsa_algorithms.practice;

import java.util.*;
public class L1994 {
    private final int[] primeNos = {2,3,5,7,11,13,17,19,23,29};
    private final int MOD = 1_000_000_7;
    public int numberOfGoodSubsets(int[] nums) {
        int n = nums.length;
        Long[][] dp = new Long[n][(1<<10)+1];
        Integer[] arr = extract(nums);

        return (int)numberOfGoodSubsets(arr, arr.length, 0, 0, dp);
    }

    private long numberOfGoodSubsets(Integer[] nums, int n, int i, int mask, Long[][] dp) {
        if (i >= n){
            return mask == 0 ? 0 : 1;
        }
        if (dp[i][mask] != null){
            return dp[i][mask];
        }
        long count = numberOfGoodSubsets(nums, n, i+1, mask, dp);
        int newMask = 0;
        for(int j=0; j<primeNos.length && nums[i] >= primeNos[j]; j++){
            if (nums[i]%primeNos[j] == 0){
                newMask |= (1<<(primeNos.length-j-1));
            }
        }
        if ((newMask & mask) == 0){
            count = (count + numberOfGoodSubsets(nums, n, i+1, mask | newMask, dp))%MOD;
        }
        return dp[i][mask] = count;
    }
    private Integer[] extract(int[] nums){
        List<Integer> arr = new ArrayList<>();

        for(int num:nums){
            boolean flag = true;
            for(int prime:primeNos){
                if (num%(prime*prime) == 0){
                    flag = false;
                    break;
                }
            }
            if (flag){
                arr.add(num);
            }
        }
        return arr.toArray(new Integer[0]);
    }
}
