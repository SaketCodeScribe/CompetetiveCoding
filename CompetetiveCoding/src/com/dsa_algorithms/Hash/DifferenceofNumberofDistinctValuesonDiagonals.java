package com.dsa_algorithms.Hash;

import java.util.*;
public class DifferenceofNumberofDistinctValuesonDiagonals {
    public int[][] differenceOfDistinctValues(int[][] g) {
        int m = g.length;
        int n = g[0].length;
        int[][] res = new int[m][n];

        for (int j = 0; j < n; ++j) {
            populateDiag(0, j, g, res, m, n);
        }
        for (int i = 1; i < m; ++i) {
            populateDiag(i, 0, g, res, m, n);
        }

        return res;
    }

    private void populateDiag(int i, int j, int[][] g, int[][] res, int m, int n) {
        Set<Integer> tl = new HashSet<>();
        Set<Integer> br = new HashSet<>();

        for (int d = 0; i + d < m && j + d < n; ++d) {
            res[i + d][j + d] = tl.size();
            tl.add(g[i + d][j + d]);
        }
        for (int d = Math.min(m - i, n - j) - 1; d >= 0; --d) {
            res[i + d][j + d] = Math.abs(res[i + d][j + d] - br.size());
            br.add(g[i + d][j + d]);
        }
    }
}
