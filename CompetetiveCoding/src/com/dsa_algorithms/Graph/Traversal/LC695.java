package com.dsa_algorithms.Graph.Traversal;

public class LC695 {
    private static final int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0, i, j, m = grid.length, n = grid[0].length;

        for(i=0; i<m; i++){
            for(j=0; j<n; j++){
                if (grid[i][j] == 1){
                    maxArea = Math.max(maxArea, coveredArea(i, j, m, n, grid));
                }
            }
        }
        return maxArea;
    }
    private int coveredArea(int i, int j, int m, int n, int[][] grid){
        int area = 1;
        grid[i][j] = 0;

        for (int[] dir:dirs){
            int x = i+dir[0], y = j+dir[1];
            if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1){
                area += coveredArea(x, y, m, n, grid);
            }
        }
        return area;
    }
}
