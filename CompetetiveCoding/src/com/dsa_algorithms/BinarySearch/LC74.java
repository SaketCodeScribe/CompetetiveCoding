package com.dsa_algorithms.BinarySearch;

public class LC74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        long m = matrix.length, n = matrix[0].length, low = 0, high = m*n-1, mid;

        while(low <= high){
            mid = low + (high-low)/2;
            int midRow = (int)(mid/n), midCol = (int)(mid%n);
            if (matrix[midRow][midCol] == target) return true;
            if (matrix[midRow][midCol] > target) high = mid-1;
            else low = mid + 1;
        }
        return false;
    }
}
