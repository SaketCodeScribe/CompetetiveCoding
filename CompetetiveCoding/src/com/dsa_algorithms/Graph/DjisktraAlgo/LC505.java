package com.dsa_algorithms.Graph.DjisktraAlgo;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC505 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length, sRow = start[0], sCol = start[1], dRow = destination[0], dCol = destination[1];

        if(!isEligigble(maze, m ,n, dRow, dCol)){
            return -1;
        }

        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        int[][] steps = new int[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        for(int i=0; i<m; i++){
            Arrays.fill(steps[i], Integer.MAX_VALUE);
        }
        steps[sRow][sCol] = 0;
        pq.offer(new int[]{sRow, sCol, 0});

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int row = top[0], col = top[1], step = top[2];
            if (steps[row][col] < step){
                continue;
            }
            if (row == dRow && col == dCol){
                return step;
            }
            for(int[] dir:dirs){
                int x = row+dir[0], y = col+dir[1];
                while(x >= 0 && y >= 0 && x < m && y < n && maze[x][y] == 0){
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                int currStep = step + Math.abs(row - x) + Math.abs(col - y);
                if (steps[x][y] > currStep){
                    steps[x][y] = currStep;
                    pq.offer(new int[]{x, y, steps[x][y]});
                }
            }
        }
        return -1;
    }
    private boolean isEligigble(int[][] maze, int m, int n, int row, int col){
        if (row == 0 || row == m-1 || col == 0 || col == n-1){
            return true;
        }
        return maze[row+1][col] == 1 || maze[row-1][col] == 1 || maze[row][col+1] == 1 || maze[row][col-1] == 1;
    }
}
