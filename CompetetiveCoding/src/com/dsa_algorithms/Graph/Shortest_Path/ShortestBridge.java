package com.dsa_algorithms.Graph.Shortest_Path;

import java.util.*;
public class ShortestBridge {
    Queue<int[]> queue;
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public int shortestBridge(int[][] grid) {
        int i, j, m = grid.length, n = grid[0].length, level = 0;
        queue = new LinkedList<>();

        for(i=0; i<m; i++){
            for(j=0; j<n; j++){
                if (grid[i][j] == 1){
                    findOuterLayer(grid, i, j, m, n);
                    break;
                }
            }
            if (!queue.isEmpty())
                break;
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int[] node = queue.poll();
                for(int[] dir:dirs){
                    int x = node[0]+dir[0], y = node[1]+dir[1];
                    if (x >= 0 && y >=0 && x < m && y < n && grid[x][y] != 2){
                        if (grid[x][y] == 1)
                            return level;
                        grid[x][y] = 2;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            level++;
        }
        return level;
    }

    public void findOuterLayer(int[][] grid, int i, int j, int m, int n){
        grid[i][j] = 2;

        for(int[] dir:dirs){
            int x = i+dir[0], y = j+dir[1];
            if (x >= 0 && y >=0 && x < m && y < n && grid[x][y] == 1)
                findOuterLayer(grid, x, y, m, n);
            else if (x >= 0 && y >=0 && x < m && y < n && grid[x][y] == 0)
                queue.add(new int[]{i, j});
        }
    }
}
