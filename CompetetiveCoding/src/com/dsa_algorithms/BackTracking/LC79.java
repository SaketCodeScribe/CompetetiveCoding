package com.dsa_algorithms.BackTracking;

public class LC79 {
    private static final int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (word.charAt(0) == board[i][j] && dfs(board, word, m, n, 0, i, j)) return true;
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int m, int n, int ind, int i, int j) {
        char ch = board[i][j];
        board[i][j] = 0;

        if (ind == word.length() - 1) {
            return true;
        }

        for (int[] dir : DIRS) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && y >= 0 && x < m && y < n && board[x][y] == word.charAt(ind + 1)) {
                if (dfs(board, word, m, n, ind + 1, x, y)) return true;
            }
        }
        board[i][j] = ch;
        return false;
    }
}
