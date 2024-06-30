package com.dsa_algorithms.DynamicProgramming;

public class MaximumAndSumOfArray {
    int[][] dp;
    public int maximumANDSum(int[] coins, int slots) {
        dp = new int[slots+1][1<<coins.length];
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, -1));
        return recursion(0, 1, slots, coins.length, coins);
    }

    public int recursion(int bitMask, int slot, int slots, int coin, int[] coins) {
        if (slot > slots)
            return 0;
        if (dp[slot][bitMask] != -1)
            return dp[slot][bitMask];
        int i, j, res;
        res = recursion(bitMask, slot+1, slots, coin, coins);

        for(i=0; i<coin; i++){
            if ((bitMask&(1<<i)) == 0){
                res = Math.max(res, recursion(bitMask | (1<<i), slot+1, slots, coin, coins)+(slot&coins[i]));
                for(j = i+1; j<coin; j++){
                    if ((bitMask&(1<<j)) == 0)
                        res = Math.max(res, recursion(bitMask | (1<<i) | (1<<j), slot+1, slots, coin, coins)+
                                (slot&coins[i])+(slot&coins[j]));
                }
            }
        }
        return dp[slot][bitMask] = res;
    }
}
