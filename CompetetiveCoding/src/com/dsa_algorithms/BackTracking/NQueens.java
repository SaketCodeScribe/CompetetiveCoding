package com.dsa_algorithms.BackTracking;
import java.util.*;
import java.util.stream.Collectors;

public class NQueens {
    static ArrayList<ArrayList<Integer>> ans;
    static int[][] temp;
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        // Write your code here.
        ans = new ArrayList<>();
        temp = new int[n][n];

        recursion(0, n);
        return ans;
    }

    public static void recursion(int j, int n){
        if (j >= n){
            ans.add(new ArrayList<>(Arrays.stream(temp)
                    .flatMapToInt(Arrays::stream)
                    .boxed()
                    .collect(Collectors.toList())));
            return;
        }
        for(int i=0; i<n; i++){
            if (isSafe(temp, i, j, n)){
                temp[i][j] = 1;
                recursion(j+1, n);
                temp[i][j] = 0;
            }
        }
    }
    public static boolean isSafe(int[][] board, int row, int column, int n) {
        int x, y;

        for (y = 0; y < column; y++) {
            if (board[row][y] == 1) {
                return false;
            }
        }

        for (x = row, y = column; x >= 0 && y >= 0; x--, y--) {
            if (board[x][y] == 1) {
                return false;
            }
        }

        for (x = row, y = column; x < n && y >= 0; x++, y--) {
            if (board[x][y] == 1) {
                return false;
            }
        }

        return true;
    }
}
