package com.dsa_algorithms.Array.Transpose_of_a_matrix;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int i, j, m = matrix.length, n = matrix[0].length;

        for(i=0; i<m; i++){
            for(j=i; j<n; j++)
                swap(matrix, i, j);
        }
        for(j=0; j<n/2; j++){
            for(i=0; i<m; i++)
                swap(matrix, i, j, n-j-1);
        }
    }
    public void swap(int[][] nums, int i, int j){
        if (nums[i][j] == nums[j][i])
            return;
        nums[i][j] = nums[i][j]+nums[j][i];
        nums[j][i] = nums[i][j]-nums[j][i];
        nums[i][j] = nums[i][j]-nums[j][i];
    }
    public void swap(int[][] nums, int i, int a, int b){
        if (nums[i][a] == nums[i][b])
            return;
        nums[i][a] = nums[i][a]+nums[i][b];
        nums[i][b] = nums[i][a]-nums[i][b];
        nums[i][a] = nums[i][a]-nums[i][b];
    }
}
