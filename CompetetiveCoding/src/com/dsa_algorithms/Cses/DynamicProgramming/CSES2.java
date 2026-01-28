package com.dsa_algorithms.Cses.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class CSES2 {

    public static final int VAL = 1_000_000_000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int i, j, ans = 0, n = scanner.nextInt(), target = scanner.nextInt();
            int[] coins = new int[n];
            i = 0;
            while (i < n) {
                coins[i++] = scanner.nextInt();
            }
            Arrays.sort(coins);
            System.out.println(minimumCoins(n, target, coins));
        }
    }

    private static int minimumCoins(int n, int target, int[] coins) {
        int i, j;
        int[] dp = new int[target+1];

        Arrays.fill(dp, VAL);
        dp[0] = 0;

        for(i=1; i<=target; i++){
            for(j=0; j<n; j++){
                if (coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
                else break;
            }
        }
        return dp[target] < VAL ? dp[target] : -1;
    }
}
