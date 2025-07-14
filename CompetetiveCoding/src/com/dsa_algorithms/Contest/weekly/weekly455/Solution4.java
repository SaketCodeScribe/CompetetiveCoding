package com.dsa_algorithms.Contest.weekly.weekly455;

import java.math.BigInteger;

public class Solution4 {
    private final int MOD = 1_000_000_007;
    public int countNumbers(String l, String r, int b) {
        String num1 = convert(decrement(l), b);
        String num2 = convert(r, b);
        return (countNumbers(num2, num2.length(), b, 0, 0, 1, new Integer[num2.length()][b][2])
                - countNumbers(num1, num1.length(), b, 0, 0, 1, new Integer[num1.length()][b][2]) + MOD)%MOD;
    }
    private String convert(String num, int base){
        return new BigInteger(num).toString(base);
    }

    private int countNumbers(String num, int n, int base, int i, int last, int state, Integer[][][] dp) {
        if (i == n){
            return 1;
        }
        if (dp[i][last][state] != null){
            return dp[i][last][state];
        }
        int result = 0;
        int digit = num.charAt(i) - '0';
        if (state == 1){
            for(int d = last; d <= digit; d++){
                result = (result + countNumbers(num, n, base, i+1, d, d == digit ? 1 : 0, dp))%MOD;
            }
        }
        else{
            for(int d = last; d < base; d++) {
                result = (result + countNumbers(num, n, base, i + 1, d, 0, dp)) % MOD;
            }
        }
        return dp[i][last][state] = result;
    }

    private String decrement(String num){
        int i, n = num.length();
        for(i=n-1; i>=0; i--){
            if (num.charAt(i) != '0'){
                break;
            }
        }
        StringBuilder digit = new StringBuilder(num.substring(0, i) + String.valueOf((num.charAt(i) - '0') - 1));
        while(++i < n){
            digit.append("9");
        }
        return digit.toString();
    }

    public static void main(String[] args) {
        Solution4 obj = new Solution4();
        System.out.println(obj.countNumbers("2", "7", 2));
    }
}
