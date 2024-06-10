package com.dsa_algorithms.Graph;
import java.util.*;

public class ShortestPathInABinaryMatrix {
    public static int findShortestPath(int[][] mat,
                                       int sourceX, int sourceY,
                                       int destX, int destY,
                                       int m, int n) {
        // Write your code here.
        if (m == 0 || n == 0)
            return -1;
        if (mat[destX][destY] == 0)
            return -1;
        if (sourceX == destX && sourceY == destY)
            return 1;
        int ans = 0;
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sourceX, sourceY});
        vis[sourceX][sourceY] = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            ans++;
            while(size-- > 0){
                int x = queue.peek()[0], y = queue.poll()[1];
                if (x == destX && y == destY)
                    return ans;
                for(int[] dir : dirs){
                    int i = x+dir[0], j = y+dir[1];
                    if (i < m && j < n && i >= 0 && j >= 0 && !vis[i][j] && mat[i][j] == 1){
                        vis[i][j] = true;
                        queue.add(new int[]{i,j});
                    }
                }
            }
        }
        return -1;
    }
}
