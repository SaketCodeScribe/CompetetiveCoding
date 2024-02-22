package com.dsa_algorithms.Graph;

import java.util.*;

public class DistinctIslands2 {
    static Set<String> set;
    static boolean[][] vis;
    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static int distinctIsland(int[][] arr, int m, int n) {
        int i, j;
        String str;
        set = new HashSet<>();
        vis = new boolean[m][n];

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (!vis[i][j] && arr[i][j] == 1)
                    set.add(dfs(arr, i, j, m, n, new StringBuilder()).toString());
            }
        }
        return set.size();
    }

    private static StringBuilder dfs(int[][] arr, int i, int j, int m, int n, StringBuilder stringBuilder) {
        if (!(i >= 0 && j >= 0 && i < m && j < n && !vis[i][j] && arr[i][j] == 1))
            return stringBuilder;
        vis[i][j] = true;
        for (int[] dir : dirs) {
            if (dir[0] == 0 && dir[1] == 1)
                stringBuilder.append('r');
            else if (dir[0] == 0 && dir[1] == -1)
                stringBuilder.append('l');
            else if (dir[0] == 1 && dir[1] == 0)
                stringBuilder.append('d');
            else
                stringBuilder.append('u');
            dfs(arr, i + dir[0], j + dir[1], m, n, stringBuilder);
        }
        return stringBuilder;
    }
}

