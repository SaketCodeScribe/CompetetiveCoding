package com.dsa_algorithms.Array.Matrix;

public class LC840 {
    public int numMagicSquaresInside(int[][] grid) {
        int i, j, k, l, m = grid.length, n = grid[0].length, count = 0;

        for(i=0; i<=m-3; i++){
            for(j=0; j<=n-3; j++){
                if (validDigits(grid, i, j) && rowSumEqual(grid, i, j) && colSumEqual(grid, i, j) && diagSumEqual(grid, i, j)){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean validDigits(int[][] grid, int row, int col){
        int i, j;
        int[] d = new int[10];

        for(i=row; i<row+3; i++){
            for(j=col; j<col+3; j++){
                if (grid[i][j] == 0 || grid[i][j] > 9 || d[grid[i][j]] == 1){
                    return false;
                }
                d[grid[i][j]]++;
            }
        }
        return true;
    }
    private boolean rowSumEqual(int[][] grid, int row, int col){
        int i, j, prev = -1, curr;

        for(i=row; i<row+3; i++){
            curr = 0;
            for(j=col; j<col+3; j++){
                curr += grid[i][j];
            }
            if (i != row && prev != curr){
                return false;
            }
            prev = curr;
        }
        return true;
    }
    private boolean colSumEqual(int[][] grid, int row, int col){
        int i, j, prev = -1, curr;

        for(i=col; i<col+3; i++){
            curr = 0;
            for(j=row; j<row+3; j++){
                curr += grid[j][i];
            }
            if (i != col && prev != curr){
                return false;
            }
            prev = curr;
        }
        return true;
    }
    private boolean diagSumEqual(int[][] grid, int row, int col){
        int i, d1 = 0, d2 = 0;

        for(i=0; i<3; i++){
            d1 += grid[i+row][i+col];
            d2 += grid[i+row][col+2-i];
        }
        return d1 == d2;
    }
}
