package com.dsa_algorithms.practice;

import java.util.*;

public class L2572 {
    private final int MOD = 1_000_000_007;
    private final int[] primes = {1,2,3,5,7,11,13,17,19,23,29};
    public int squareFreeSubsets(int[] nums) {
        int n = nums.length;
        List<Integer> arr = extracted(nums);
        System.out.println(arr);

        Long[][] dp = new Long[n][(1<<11)+1];
        return ((int)noOfSquareFreeSubsets(arr, arr.size(), 0, 0, dp)-1+MOD)%MOD;
    }

    private long noOfSquareFreeSubsets(List<Integer> arr, int size, int i, int mask, Long[][] dp) {
        if (i >= size){
            return 1;
        }
        if (dp[i][mask] != null){
            return dp[i][mask];
        }
        long count = noOfSquareFreeSubsets(arr, size, i+1, mask, dp);
        int newMask = 0;
        for(int j=0; j<primes.length && arr.get(i) >= primes[j]; j++){
            if (arr.get(i) % primes[j] == 0){
                newMask |= (1<<(primes.length-j-1));
            }
        }
        if ((newMask & mask) == 0 || newMask == (1<<11)){
            count = (count + noOfSquareFreeSubsets(arr, size, i+1, newMask, dp))%MOD;
        }
        return dp[i][mask] = count;
    }

    private int extract(int num){
        int i;
        for(i=0; i<primes.length; i++){
            if (num % primes[i] == 0){
                return primes.length - i - 1;
            }
        }
        return -1;
    }

    private List<Integer> extracted(int[] nums) {
        List<Integer> arr = new ArrayList<>();

        for(int num: nums){
            if (num == 1){
                arr.add(num);
            }
            else{
                boolean flag = true;
                for(int prime:primes){
                    if (prime > 1 && num%(prime*prime) == 0){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    arr.add(num);
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        L2572 obj = new L2572();
        System.out.println(obj.squareFreeSubsets(new int[]{3, 12, 3, 5, 4, 9, 8, 5, 7, 3, 4, 29, 8, 5, 7, 3, 8, 9, 4, 5, 7, 8, 3, 9, 4, 7, 5, 9, 8, 3, 4, 7, 5, 9, 3, 4, 27, 5,
                8, 9, 4, 6, 8, 9, 23, 7, 6, 5, 8, 9, 17, 6, 5, 9, 6, 5, 4, 3, 26, 5, 8, 7, 6, 5, 8, 7, 3, 24, 6, 5}));
    }
}
