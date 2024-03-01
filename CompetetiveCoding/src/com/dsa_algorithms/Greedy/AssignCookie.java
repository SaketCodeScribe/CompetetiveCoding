package com.dsa_algorithms.Greedy;

import java.util.Arrays;

public class AssignCookie {
    public int findContentChildren(int[] g, int[] s) {
        int i, j, m = g.length, n = s.length, ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        i = j = 0;
        while (i < m && j < n){
            while(j < n && g[i] > s[j])
                j++;
            if (j < n) {
                ans++;
                j++;
            }
        }
        return ans;
    }
}
