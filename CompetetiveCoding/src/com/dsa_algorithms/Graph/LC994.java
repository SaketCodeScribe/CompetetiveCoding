package com.dsa_algorithms.Graph;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class LC994 {
    private final int[][] DIRS = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int orangesRotting(int[][] grid) {
        int freshOranges = 0, i, j, m = grid.length, n = grid[0].length, time = -1;
        Queue<Integer> queue = new LinkedList<>();

        for(i=0; i<m; i++) {
            for(j=0; j<n; j++) {
                if (grid[i][j] == 2) queue.offer(i * n + j);
                else if (grid[i][j] == 1) freshOranges++;
            }
        }
        if (freshOranges == 0) return 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int ind = Objects.requireNonNull(queue.poll());
                int x = ind/n, y = ind%n;
                for(int[] dir:DIRS) {
                    i = x + dir[0];
                    j = y + dir[1];
                    if (i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == 1) {
                        queue.offer(i * n + j);
                        grid[i][j] = 2;
                        freshOranges--;
                    }
                }
            }
            time++;
        }
        return freshOranges > 0 ? -1 : time;
    }
}
