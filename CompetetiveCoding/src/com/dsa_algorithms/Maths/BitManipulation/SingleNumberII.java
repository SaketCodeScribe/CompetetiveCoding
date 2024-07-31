package com.dsa_algorithms.Maths.BitManipulation;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int ans = 0, cnt = 0;

        for(int bit=0; bit<32; bit++){
            int bits = 0;
            for(int num:nums){
                bits += ((num & (1 << bit)) != 0 ? 1 : 0);

            }
            ans = ans | (bits%3 > 0 ? 1<<bit : 0);
        }

        return ans;
    }
}
