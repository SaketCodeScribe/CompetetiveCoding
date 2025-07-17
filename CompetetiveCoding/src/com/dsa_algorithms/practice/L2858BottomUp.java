package com.dsa_algorithms.practice;

public class L2858BottomUp {
    private final int MOD = 1_000_000_007;
    public int waysToReachTarget(int target, int[][] types) {
        int i, j, k, n = types.length;
        int[] curr, prev = new int[target+1];

        prev[0] = 1;
        for(i=0; i<n; i++){
            curr = new int[target+1];
            for(j=0; j<=target; j++){
                for(k=0; k<=types[i][0] && k*types[i][1] <= j; k++){
                    curr[j] = (curr[j]%MOD + prev[j-k*types[i][1]]%MOD)%MOD;
                }
            }
            prev = curr;
        }
        return prev[target];
    }
}
