package com.dsa_algorithms.Array.Simulation;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int i, j;
        boolean[][] row = new boolean[10][10], col = new boolean[10][10], boxes = new boolean[10][10];

        for(i=0; i<9; i++){
            for(j=0; j<9; j++){
                if (board[i][j] == '.')
                    continue;
                int ind = i/3*3+j/3;
                if (row[i][board[i][j]-'0'] || col[j][board[i][j]-'0'] || boxes[ind][board[i][j]-'0'])
                    return false;
                row[i][board[i][j]-'0'] = col[j][board[i][j]-'0'] = boxes[ind][board[i][j]-'0'] = true;
            }
        }
        return true;
    }
}
