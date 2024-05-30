package com.dsa_algorithms.BinarySearch;

public class SearchInARowWiseANDColWiseSortedMatrix {
    static class Pair{
        int x, y;

        public Pair(int row, int col) {
            x = row; y = col;
        }
    }
    public static Pair search(int [][] matrix, int x) {
        // Write your code here.
        int n = matrix.length;
        int row = 0, col = n-1;

        while(row < n && col >= 0){
            if (x == matrix[row][col])
                return new Pair(row, col);
            if (x < matrix[row][col])
                col--;
            else
                row++;
        }
        return new Pair(-1,-1);
    }
}
