package com.dsa_algorithms.DynamicProgramming.LinearDP;

public class LC1411 {
    private static final int MOD = 1000_000_007;
    public int numOfWays(int n) {
        int i;
        long duplicate = 6, unique = 6;  // duplicate - 121, unique - 123

        for(i=2; i<=n; i++){
            long newDup = (3*duplicate + 2*unique)%MOD;
            long newUni = (2*duplicate + 2*unique)%MOD;
            duplicate = newDup;
            unique = newUni;
        }
        return (int)((duplicate + unique)%MOD);
    }
}
