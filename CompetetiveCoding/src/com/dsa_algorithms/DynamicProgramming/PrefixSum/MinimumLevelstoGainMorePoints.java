package com.dsa_algorithms.DynamicProgramming.PrefixSum;

public class MinimumLevelstoGainMorePoints {
    public int minimumLevels(int[] possible) {
        int i, n = possible.length;
        int[] pre = new int[n];
        pre[0] = possible[0] > 0 ? 1 : -1;

        for(i=1; i<n; i++)
            pre[i] = pre[i-1]+(possible[i] > 0 ? 1 : -1);
        for(i=0; i<n-1; i++)
            if (pre[i] > pre[n-1]-pre[i])
                return i+1;
        return -1;
    }
}
