package com.dsa_algorithms.Cses.DynamicProgramming;

import java.util.Scanner;

public class CSES1 {
    private static final int MOD = 1_000_000_007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()){
            int n = scanner.nextInt();
            System.out.println(noOfDiceCombinations(n));
        }
    }

    private static int noOfDiceCombinations(int n) {
        int i, j;
        int[] dp = new int[7];
        dp[0] = 1;
        for(i=1; i<= n; i++){
            int curr = 0;
            for(j=1; j<=Math.min(i,6); j++){
                curr = (curr + dp[subtract(i, j)])%MOD;
            }
            int num = transformSum(i);
            dp[num] = curr;
        }
        return dp[transformSum(n)];
    }

    private static int subtract(int i, int j) {
        return i == j ? 0 : ((i - j) % 6 != 0 ? (i - j) % 6 : 6);
    }

    private static int transformSum(int n) {
        return n % 6 != 0 ? n % 6 : 6;
    }
}
