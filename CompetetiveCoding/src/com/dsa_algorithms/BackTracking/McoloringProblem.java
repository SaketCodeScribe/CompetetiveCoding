package com.dsa_algorithms.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    isSafe is critical if you don't use it, wrong ans will be thrown.
 */

public class McoloringProblem {
    static List<List<Integer>> adj;
    static boolean[] vis;
    static int[] color;

    public static String graphColoring(int[][] mat, int m) {
        int i, j, n = mat[0].length;
        adj = new ArrayList<>();
        vis = new boolean[n];
        color = new int[n];
        for (i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (i = 0; i < n; i++) {
            for (j = i; j < n; j++) {
                if (i == j)
                    continue;
                if (mat[i][j] == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        System.out.println(adj);
        for (i = 0; i < n; i++) {
            if (!vis[i]) {
                for (int col = 1; col <= m; col++) {
                    if (isSafe(i, col)) {
                        color[i] = col;
                        if (!dfs(i, n, m)) {
                            color[i] = 0;
                            vis[i] = false;
                        } else
                            break;
                    }
                }
                if (color[i] == 0)
                    return "NO";
            }
        }
        return "YES";
    }

    private static boolean dfs(int node, int n, int m) {
        vis[node] = true;
        for (Integer child : adj.get(node)) {

            if (!vis[child]) {
                for (int col = 1; col <= m; col++) {
                    if (isSafe(child, col)) {
                        if(col == color[node])
                            continue;
                        color[child] = col;
                        if (!dfs(child, n, m)) {
                            vis[child] = false;
                            color[child] = 0;
                        } else
                            break;
                    }
                }
                if (color[child] == 0)
                    return false;
            } else  if (color[child] == color[node])
                    return false;
        }
        return true;
    }

    private static boolean isSafe(Integer node, int col) {
        for (Integer ch : adj.get(node))
            if (color[ch] == col)
                return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0},
                {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1},
                {1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,1,1,0,1,0,0,1,0,0,0,1,1},
                {0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,0,0,0,0,0,1,0,0,1,1,0,0,0,0},
                {1,0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,0,1,0,0},
                {1,0,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,1,1,0},
                {0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1},
                {0,0,0,0,1,1,0,0,0,1,1,0,1,0,0,1,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,1,1,0,0},
                {0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,1,1,0},
                {0,0,1,0,0,0,0,0,0,0,1,1,1,1,0,1,1,0,1,1},
                {0,1,0,0,0,1,0,0,0,0,0,0,1,1,1,0,1,1,0,1},
                {0,0,1,0,0,1,1,0,0,0,0,0,0,1,0,0,0,1,1,0}
        };
        System.out.println(graphColoring(arr, 4));
    }
}
