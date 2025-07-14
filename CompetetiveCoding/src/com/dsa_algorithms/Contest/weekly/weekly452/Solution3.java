package com.dsa_algorithms.Contest.weekly.weekly452;

import java.util.*;

public class Solution3 {
    private static final int[][] dirs = {
            {-1, 0}, // up
            {1, 0},  // down
            {0, -1}, // left
            {0, 1}   // right
    };
    static int ans;
    public static int minMoves(String[] classroom, int energy) {
        int i, j, sr=-1, sc=-1, cnt = 0;
        char[][] grid = new char[classroom.length][classroom[0].length()];
        for (i = 0; i < classroom.length; i++) {
            grid[i] = classroom[i].toCharArray();
        }
        int m = grid.length;
        int n = grid[0].length;
        for(i=0; i<m; i++){
            for(j=0; j<n; j++){
                if (grid[i][j] == 'S'){
                    sr = i;
                    sc = j;
                }
                else if (grid[i][j] == 'L'){
                    cnt |= (1<<(i*n+j));
                }
            }
        }
        if (sr == -1){
            return -1;
        }
        Map<String, Integer> dp = new HashMap<>();
        dp.put(sr+","+sc+","+energy, 0);
        Set<String> vis = new HashSet<>();
        ans = (int)1e9;

        solveWithDp(grid, m, n, energy, cnt, vis, sr, sc, energy, 0, 0, dp);
        return ans < (int)1e9 ? (int)ans : -1;
    }
    private static void solveWithDp(char[][] grid, int m, int n, int energy, int totalLitter, Set<String> vis, int row, int col, int currEnergy, int mask, int moves, Map<String, Integer> dp) {
        if (mask == totalLitter) {
            ans = Math.min(ans, moves);
        }
        if (currEnergy <= 0){
            return ;
        }
        String key = row+","+col+","+currEnergy+","+mask;
        if (vis.contains(key)){
            return;
        }
        vis.add(key);
        for(int[] dir:dirs){
            int i = row+dir[0], j = col+dir[1];
            int newMask = mask;
            if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] != 'X'){
                if (grid[i][j] == 'L'){
                    newMask = mask | (1<<(i*n+j));
                }
                currEnergy = grid[i][j] == 'R' ? energy : currEnergy-1;
                String key1 = i + "," + j + "," + currEnergy;
                if (dp.getOrDefault(key1, Integer.MAX_VALUE) > moves+1){
                    dp.put(key1, moves+1);
                }
                solveWithDp(grid, m, n, energy, totalLitter, vis, i, j, currEnergy, newMask, moves+1, dp);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(minMoves(new String[]{"L", "R", ".", "S", "."}, 1));
    }
}
