package com.dsa_algorithms.Contest.weekly.weekly452;

import java.util.Iterator;
import java.util.TreeSet;

public class Solution2 {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int i, j, p, q, m = grid.length, n = grid[0].length;
        int[][] ans = new int[m-k+1][n-k+1];

        for(i=0; i<=m-k; i++){
            for(j=0; j<=n-k; j++){
                TreeSet<Integer> tree = new TreeSet<>();
                int diff = Integer.MAX_VALUE;
                for(p=i; p<i+k; p++){
                    for(q=j; q<j+k; q++){
                        tree.add(grid[p][q]);
                    }
                }
                Iterator<Integer> itr = tree.iterator();
                Integer prev = null;
                while(itr.hasNext()){
                    Integer curr = itr.next();
                    if (prev != null) {
                        diff = Math.min(Math.abs(curr - prev), diff);
                    }
                    prev = curr;
                }
                ans[i][j] = diff;
            }
        }
        return ans;
    }
}
