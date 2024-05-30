package com.dsa_algorithms.DynamicProgramming;

import java.util.ArrayList;

public class Knapsack01 {
    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        int i, j;
        int[] curr = new int[w+1], prev = new int[w+1];

        for(i=0; i < n; i++){
            curr = new int[w+1];
            for(j=1; j <= w; j++)
                curr[j] = Math.max(prev[j], j >= weights.get(i) ? prev[j-weights.get(i)]+values.get(i) : 0);
            prev = curr;
        }
        return curr[w];
    }
}
