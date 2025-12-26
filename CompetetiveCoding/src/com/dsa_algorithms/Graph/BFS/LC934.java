package com.dsa_algorithms.Graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LC934 {
    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length, i, j;
        boolean flag = false;
        boolean[][] vis = new boolean[m][n];
        int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> queue = new LinkedList<>();

        for(i=0; i<m && !flag; i++){
            for(j=0; j<n && !flag; j++){
                if (grid[i][j] == 1 && !vis[i][j]){
                    dfs(i, j, vis, queue, grid, m, n);
                    flag = true;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int flips = node[2];
            for(int[] direction:directions){
                int x = node[0] + direction[0], y = node[1] + direction[1];
                if (x >= 0 && x < m && y >= 0 && y < n){
                    if (grid[x][y] == 0 && !vis[x][y]){
                        queue.offer(new int[]{x, y, flips + 1});
                        vis[x][y] = true;
                    }
                    else if (grid[x][y] == 1 && !vis[x][y]){
                        return flips;
                    }
                }
            }
        }
        return -1;
    }
    private void dfs(int row, int col, boolean[][] vis, Queue<int[]> queue, int[][] grid, int m, int n){
        int x, y, siblings = 0;
        int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        vis[row][col] = true;

        for(int[] direction:directions){
            x = row + direction[0];
            y = col + direction[1];
            if (x >= 0 && x < m && y >=0 && y < n && grid[x][y] == 1){
                if (!vis[x][y]){
                    dfs(x, y, vis, queue, grid, m, n);
                }
                siblings++;
            }
        }
        if (siblings < 4){
            queue.offer(new int[]{row, col, 0});
        }
    }
}
