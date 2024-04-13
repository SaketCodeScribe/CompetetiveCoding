package com.dsa_algorithms.DynamicProgramming;

/*
    DFS + Memoization has worked here because you can go only in one direction from Node A to node B.
    If this wasn't the case then it would have failed in a simlar fashion when finding shortest path using DFS.
*/
public class LongestIncreasingPathinaMatrix {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] cache;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        cache = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int i, int j, int m, int n) {
        if(cache[i][j] != 0)
            return cache[i][j];
        int max = 1;
        for(int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, m, n);
            max = Math.max(max, len);
        }
        return cache[i][j] = max;
    }
}
