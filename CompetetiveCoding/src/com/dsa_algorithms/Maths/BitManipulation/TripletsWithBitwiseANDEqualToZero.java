package com.dsa_algorithms.Maths.BitManipulation;

public class TripletsWithBitwiseANDEqualToZero {
    public int countTriplets(int[] nums) {
        int i, ans = 0;
        int[] cnt = new int[1<<16];

        for(int a:nums){
            for(int b:nums)
                cnt[a&b]++;
        }
        for(int a:nums){
            for(i=0; i<(1<<16); i++)
                if((a&i) == 0)
                    ans += cnt[i];
        }
        return ans;
    }
}
