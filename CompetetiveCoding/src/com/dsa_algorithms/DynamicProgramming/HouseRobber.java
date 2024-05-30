package com.dsa_algorithms.DynamicProgramming;

public class HouseRobber {
    public static int maxMoneyLooted(int[] houses) {
        int i, n = houses.length, prev = 0, pprev = 0, curr = 0;

        for(i=0; i<n; i++){
            curr = Math.max(prev, pprev+houses[i]);
            pprev = Math.max(prev, pprev);
            prev = curr;
        }
        return curr;
    }
}
