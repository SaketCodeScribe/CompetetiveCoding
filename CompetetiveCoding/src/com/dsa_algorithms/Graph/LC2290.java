package com.dsa_algorithms.Graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LC2290 {
    private final int[][] DIRS = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Deque<int[]> dq = new ArrayDeque<>();
        int[] costs = new int[m*n];

        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[0] = 0;
        dq.offer(new int[]{0,0});

        while(!dq.isEmpty()) {
            int[] top = dq.pollFirst();
            if (top[0] == m*n-1) return top[1];
            if (top[1] > costs[top[0]]) continue;
            int i = top[0]/n, j = top[0]%n;
            for(int[] dir:DIRS) {
                int x = i + dir[0], y = j + dir[1];
                if (x >= 0 && y >= 0 && x < m && y < n) {
                    int ind = x * n + y;
                    if (costs[ind] > top[1] + grid[x][y]) {
                        costs[ind] = top[1] + grid[x][y];
                        if (grid[x][y] == 0) dq.offerFirst(new int[]{ind, costs[ind]});
                        else dq.offerLast(new int[]{ind, costs[ind]});
                    }
                }
            }
        }
        return -1;
    }
}
