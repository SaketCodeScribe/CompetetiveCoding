package com.dsa_algorithms.PrefixSum;

public class LC304 {
    private final long[][] rectangleSum;
    private final int m, n;

    public LC304(int[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.rectangleSum = new long[m+1][n+1];
        computeRectanglePrefixSum(matrix);

    }

    private void computeRectanglePrefixSum(int[][] matrix){
        int i, j;

        for(i=1; i<=this.m; i++){
            long sum = 0;
            for(j=1; j<=this.n; j++){
                sum += matrix[i-1][j-1];
                this.rectangleSum[i][j] = sum + this.rectangleSum[i-1][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return (int)(this.rectangleSum[row2+1][col2+1] - this.rectangleSum[row1][col2+1] - this.rectangleSum[row2+1][col1] + this.rectangleSum[row1][col1]);
    }
}
