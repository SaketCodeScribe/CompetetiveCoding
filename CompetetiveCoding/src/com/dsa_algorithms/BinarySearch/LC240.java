package com.dsa_algorithms.BinarySearch;

public class LC240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length-1, n = matrix[0].length-1, row = 0, col = n;
        while(row <= m && col >= 0){
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] < target) row++;
            else col--;
        }
        return false;
    }
}
