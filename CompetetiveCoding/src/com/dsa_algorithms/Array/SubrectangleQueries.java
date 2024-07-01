package com.dsa_algorithms.Array;

import java.util.*;
public class SubrectangleQueries {
    int[][] matrix;
    List<int[]> list;
    public SubrectangleQueries(int[][] rectangle) {
        matrix = rectangle;
        list = new ArrayList<>();
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        list.add(new int[]{row1, col1, row2, col2, newValue});
    }

    public int getValue(int row, int col) {
        int i, n = list.size();
        i = n;

        while(i-- > 0){
            int[] index = list.get(i);
            if (index[0] <= row && index[2] >= row && index[1] <= col && index[3] >= col)
                return index[4];
        }
        return matrix[row][col];
    }
}
