package com.dsa_algorithms.DynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class LC1301 {
    static final int MOD = 1_000_000_007;

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        long[][] score = new long[n][n];
        long[][] cnt = new long[n][n];
        for (long[] row : score) Arrays.fill(row, -1);

        score[n - 1][n - 1] = 0;
        cnt[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                char c = board.get(i).charAt(j);
                if (c == 'X' || (i == n - 1 && j == n - 1)) continue;

                long best = -1, ways = 0;
                int[][] dirs = {{i + 1, j}, {i, j + 1}, {i + 1, j + 1}};
                for (int[] d : dirs) {
                    if (d[0] < n && d[1] < n && score[d[0]][d[1]] > best) {
                        best = score[d[0]][d[1]];
                        ways = cnt[d[0]][d[1]];
                    } else if (d[0] < n && d[1] < n && score[d[0]][d[1]] == best && best != -1) {
                        ways = (ways + cnt[d[0]][d[1]]) % MOD;
                    }
                }
                if (best == -1) continue;

                score[i][j] = best + (c == 'E' ? 0 : c - '0');
                cnt[i][j] = ways;
            }
        }

        return score[0][0] == -1 ? new int[]{0, 0}
                : new int[]{(int) (score[0][0] % MOD), (int) cnt[0][0]};
    }
}
