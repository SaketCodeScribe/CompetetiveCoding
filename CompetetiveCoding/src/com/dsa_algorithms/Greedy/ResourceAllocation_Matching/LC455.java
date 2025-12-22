package com.dsa_algorithms.Greedy.ResourceAllocation_Matching;

import java.util.Arrays;

public class LC455 {
    public int findContentChildren(int[] g, int[] s) {
        int i, j, m = g.length, n = s.length, cnt = 0;
        Thread t1 = new Thread(() -> Arrays.sort(g));
        Thread t2 = new Thread(() -> Arrays.sort(s));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch(Exception e) {}

        for(i=0, j = 0; i<m && j < n; j++){
            if (g[i] <= s[j]){
                cnt++;
                i++;
            }
        }
        return cnt;
    }
}
