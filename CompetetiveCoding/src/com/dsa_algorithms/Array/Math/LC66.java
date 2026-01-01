package com.dsa_algorithms.Array.Math;

public class LC66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length, i = n-1, carry = 1;

        while(i>=0){
            int value = digits[i] + carry;
            digits[i--] = value%10;
            carry = value/10;
        }
        if (carry == 0){
            return digits;
        }
        i = 0;
        int[] ans = new int[n+1];
        ans[i++] = carry;
        for(int d:digits){
            ans[i++] = d;
        }
        return ans;
    }
}
