package com.dsa_algorithms.DynamicProgramming.GridDP;

public class LC931 {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, i, j;

        for(i=1; i<m; i++){
            for(j=0; j<n; j++){
                int fromAbove = matrix[i - 1][j];
                int fromLeftDiag = (j > 0) ? matrix[i - 1][j - 1] : Integer.MAX_VALUE;
                int fromRightDiag = (j < n - 1) ? matrix[i - 1][j + 1] : Integer.MAX_VALUE;

                int bestPrev = Math.min(fromAbove, Math.min(fromLeftDiag, fromRightDiag));
                matrix[i][j] += bestPrev;
            }
        }
        return getMinimumElement(matrix[m-1], n);
    }
    private int getMinimumElement(int[] arr, int n){
        int i, ans = Integer.MAX_VALUE;
        for(i=0; i<n; i++){
            ans = Math.min(ans, arr[i]);
        }
        return ans;
    }
}
