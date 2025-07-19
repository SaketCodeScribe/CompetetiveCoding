package com.dsa_algorithms.practice;

public class L1594 {
    private final int MOD = 1_000_000_007;
    public int maxProductPath(int[][] grid) {
        int i, j, m = grid.length, n = grid[0].length;
        long[][][] product = new long[m][n][2]; // 0 - pos, 1 - neg


        for(i=0; i<m; i++){
            for(j=0; j<n; j++){
                if (i == 0 && j == 0){
                    product[i][j][0] = Integer.MIN_VALUE;
                    if (grid[i][j] > 0){
                        product[i][j][0] = grid[i][j];
                    }
                    else{
                        product[i][j][1] = grid[i][j];
                    }
                }
                else{
                    if (i > 0) {
                        product[i][j][0] = Math.max(multiply(product[i-1][j][0], grid[i][j], 0), mult(product[i-1][j][1], grid[i][j], 0));
                        product[i][j][1] = Math.min(multiply(product[i-1][j][0], grid[i][j], 1), mult(product[i-1][j][1], grid[i][j], 1));
                    }
                    if (j > 0){
                        product[i][j][0] = Math.max(product[i][j][0],
                                                        Math.max(multiply(product[i][j-1][0], grid[i][j], 0),
                                                                    mult(product[i][j-1][1], grid[i][j], 0)));
                        product[i][j][1] = Math.min(product[i][j][1],
                                                        Math.min(multiply(product[i][j-1][0], grid[i][j], 1),
                                                                    mult(product[i][j-1][1], grid[i][j], 1)));
                    }
                    if (product[i][j][0] < 0){
                        product[i][j][0] = Integer.MIN_VALUE;
                    }
                }
            }
        }
        int ans = (int) (Math.max(product[m - 1][n - 1][0], product[m - 1][n - 1][1]) % MOD);
        return ans < 0 ? -1 : ans;
    }

    private static long mult(long a, int num, int type) {
        if (type == 0 && a == Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        if (type == 1 && a == Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return a * num;
    }

    private static long multiply(long a, int num, int type) {
        if (type == 0 && a == Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        if (type == 1 && a == Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        return a * num;
    }
}
