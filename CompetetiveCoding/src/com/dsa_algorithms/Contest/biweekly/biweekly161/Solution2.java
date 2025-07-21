package com.dsa_algorithms.Contest.biweekly.biweekly161;

public class Solution2 {
    private final int[][] DIRS = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int countIslands(int[][] grid, int k) {
        int i, j, noOfIsland = 0, m = grid.length, n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        for(i=0; i<m; i++){
            for(j=0; j<n; j++){
                if (!vis[i][j] && grid[i][j] > 0){
                    long islandValue = dfs(grid, m, n, i, j, vis);
                    System.out.println(i+","+j+" :"+islandValue);
                    if (islandValue%k == 0){
                        noOfIsland++;
                    }
                }
            }
        }
        return noOfIsland;
    }
    private long dfs(int[][] grid, int m, int n, int i, int j, boolean[][] vis){
        long value = grid[i][j];
        vis[i][j] = true;

        for(int[] dir:DIRS){
            int x = i+dir[0], y = j+dir[1];
            if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] > 0 && !vis[x][y]){
                value += dfs(grid, m, n, x, y, vis);
            }
        }
        return value;
    }
}
