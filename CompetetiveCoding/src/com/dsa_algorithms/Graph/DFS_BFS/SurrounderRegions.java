package com.dsa_algorithms.Graph.DFS_BFS;

import java.util.*;

public class SurrounderRegions {
    public void solve(char[][] board) {
        int i, j, m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] vis = new boolean[m][n];
        int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

        for(i=0; i<m; i++){
            for(j=0; j<n; j++){
                if ((i==0 || j==0 || i==m-1 || j==n-1) && board[i][j] == 'O'){
                    queue.add(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }
        while(queue.size() > 0){
            i = queue.peek()[0];
            j = queue.poll()[1];
            for(int[] dir:dirs){
                int x = i+dir[0], y = j+dir[1];
                if (x >= 0 && x < m && y >=0 && y < n && !vis[x][y] && board[x][y] == 'O'){
                    queue.add(new int[]{x, y});
                    vis[x][y] = true;
                }
            }
        }
        for(i=0; i<m; i++){
            for(j=0; j<n; j++){
                if(!vis[i][j])
                    board[i][j] = 'X';
            }
        }
    }
}
