package com.dsa_algorithms.Hash;

import java.util.*;

public class MinimumOperationstoWritetheLetterYonaGrid {
    public int minimumOperationsToWriteY(int[][] grid) {
        int i, j, n = grid.length, tot1, tot2, ans = Integer.MAX_VALUE;
        int[] cnt1 = new int[3], cnt2 = new int[3];

        for(i=0; i<n; i++){
            for(j=0; j<n; j++){
                if ((i == j && i <= n/2) || (i+j == n-1 && i <= n/2) || (j == n/2 && i > n/2))
                    cnt1[grid[i][j]]++;
                else
                    cnt2[grid[i][j]]++;
            }
        }
        tot1 = Arrays.stream(cnt1).sum();
        tot2 = Arrays.stream(cnt2).sum();
        for(i=2; i>=0; i--){
            for(j=2; j>=0; j--){
                if (j != i)
                    ans = Math.min(ans, tot1-cnt1[i]+tot2-cnt2[j]);
            }
        }
        return ans;
    }
}
