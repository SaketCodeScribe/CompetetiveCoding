package com.dsa_algorithms.Hash;

public class LC974 {
    public int subarraysDivByK(int[] nums, int k) {
        int sum=0, cnt = 0;
        int[] map = new int[k];
        map[0] = 1;

        for(int num:nums) {
            sum += (num%k + k)%k;
            int val =  map[sum%k];
            cnt += val;
            map[sum%k] = val+1;
        }
        return cnt;
    }
}
