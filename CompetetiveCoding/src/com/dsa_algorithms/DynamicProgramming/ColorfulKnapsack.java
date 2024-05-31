package com.dsa_algorithms.DynamicProgramming;
import java.util.*;
public class ColorfulKnapsack {
    public static int colorfulKnapsack(int w[], int c[], int m, int x) {
        //    Your code goes here.
        int i, j, k, n = w.length;
        boolean[][] dp = new boolean[m+1][x+1];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(i=0; i<n; i++){
            map.putIfAbsent(c[i], new ArrayList<>());
            map.get(c[i]).add(w[i]);
        }
        for(i=1; i<=m; i++){
            if (!map.containsKey(i))
                return -1;
        }
        dp[0][0] = true;
        for(i=1; i<=m; i++){
            boolean flag = false;
            for(j=1; j<=x; j++){
                for(Integer wt:map.get(i)){
                    if (j >= wt)
                        dp[i][j] = dp[i][j] || dp[i-1][j-wt];
                    flag = flag || dp[i][j];
                }
            }
            if (!flag)
                return -1;
        }
        for(i=x; i>0; i--){
            if (dp[m][i])
                return x-i;
        }
        return -1;
    }
}
