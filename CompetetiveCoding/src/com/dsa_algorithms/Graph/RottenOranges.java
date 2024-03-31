package com.dsa_algorithms.Graph;

import java.util.*;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length, i, j, time = -1, cnt = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

        for(i=0; i<m; i++){
            for(j=0; j<n; j++){
                if (grid[i][j] == 2)
                    queue.add(new int[]{i,j});
                else if (grid[i][j] == 1)
                    cnt++;
            }
        }
        if (cnt == 0)
            return 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            time++;
            while(size-- > 0){
                int r = queue.peek()[0], c = queue.poll()[1];
                for(int[] dir:dirs){
                    if (r+dir[0] >= 0 && r+dir[0] < m && c+dir[1] >= 0 && c+dir[1] < n && grid[r+dir[0]][c+dir[1]] == 1){
                        queue.add(new int[]{r+dir[0], c+dir[1]});
                        grid[r+dir[0]][c+dir[1]] = 2;
                    }
                }
            }
        }
        for(i=0; i<m; i++){
            for(j=0; j<n; j++){
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return time;
    }
}
