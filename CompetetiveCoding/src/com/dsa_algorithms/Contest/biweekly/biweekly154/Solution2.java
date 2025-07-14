package com.dsa_algorithms.Contest.biweekly.biweekly154;

public class Solution2 {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n < 3){
            return n;
        }
        int pow = (int)(Math.log(n)/Math.log(2));
        if (n == (int)Math.pow(2, pow)){
            return n << 1;
        }
        return n+1;
    }
}
