package com.dsa_algorithms.BackTracking;

public class WordSearch {
    int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

    public boolean exist(char[][] board, String word) {
        int i, j, m = board.length, n = board[0].length;

        for(i=0; i<m; i++){
            for(j=0; j<n; j++){
                if (word.charAt(0) == board[i][j]){
                    board[i][j] = '#';
                    if (dfsWithBackTracking(1, i, j, m, n, word.length(), word, board))
                        return true;
                    board[i][j] = word.charAt(0);
                }
            }
        }
        return false;
    }

    public boolean dfsWithBackTracking(int k, int i, int j, int m, int n, int len, String word, char[][] board){
        if (k >= len)
            return true;
        for(int[] dir:dirs){
            int r = i+dir[0], c = j+dir[1];
            if (r >= 0 && c >= 0 && r < m && c < n)
                if (r >= 0 && c >= 0 && r < m && c < n && word.charAt(k) == board[r][c]){
                    board[r][c] = '#';
                    if (dfsWithBackTracking(k+1, r, c, m, n, len, word, board))
                        return true;
                    board[r][c] = word.charAt(k);
                }
        }
        return false;
    }
}
