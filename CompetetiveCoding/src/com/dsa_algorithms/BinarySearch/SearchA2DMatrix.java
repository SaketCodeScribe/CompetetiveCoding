package com.dsa_algorithms.BinarySearch;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high, m = matrix.length, n = matrix[0].length, mid;
        high = m*n-1;

        while(low <= high){
            mid = (low+high) >> 1;
            int row = mid/n, col = mid%n;
            if (matrix[row][col] == target)
                return true;
            if (matrix[row][col] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return false;
    }
}
