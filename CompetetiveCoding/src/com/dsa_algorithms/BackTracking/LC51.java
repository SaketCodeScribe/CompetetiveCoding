package com.dsa_algorithms.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LC51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] chess = new char[n][n];
        Arrays.stream(chess).forEach(row -> Arrays.fill(row, '.'));
        solveNQueens(n, 0, 0, ans, chess);
        return ans;
    }
    private void solveNQueens(int n, int queens, int row, List<List<String>> ans, char[][] chess) {
        if (queens == n) {
            ans.add(Arrays.stream(chess).map(String::new).collect(Collectors.toList()));
            return;
        }

        for(int i=0; i<n; i++) {
            if (valid(row, i, n, chess)) {
                chess[row][i] = 'Q';
                solveNQueens(n, queens+1, row+1, ans, chess);
                chess[row][i] = '.';
            }
        }
    }
    private boolean valid(int row, int col, int n, char[][] chess) {
        int i, j;

        for(i=0; i<n; i++) {
            if (chess[i][col] == 'Q') return false;
        }
        for(j=0; j<n; j++) {
            if (chess[row][j] == 'Q') return false;
        }
        for(i=row, j=col; i<n && j<n; i++, j++) {
            if (chess[i][j] == 'Q') return false;
        }
        for(i=row, j=col; i>=0 && j>=0; i--, j--) {
            if (chess[i][j] == 'Q') return false;
        }
        for(i=row, j=col; i<n && j>=0; i++, j--) {
            if (chess[i][j] == 'Q') return false;
        }
        for(i=row, j=col; i>=0 && j<n; i--, j++) {
            if (chess[i][j] == 'Q') return false;
        }
        return true;
    }
}
