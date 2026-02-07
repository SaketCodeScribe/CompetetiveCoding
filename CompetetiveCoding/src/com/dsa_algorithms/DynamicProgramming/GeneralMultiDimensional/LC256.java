package com.dsa_algorithms.DynamicProgramming.GeneralMultiDimensional;

public class LC256 {
    public int minCost(int[][] costs) {
        int n = costs.length, i, red = 0, blue = 0, green = 0, newRed, newBlue, newGreen;

        for(i=1; i<=n; i++){
            newRed = Math.min(green, blue) + costs[i-1][0];
            newBlue = Math.min(red, green) + costs[i-1][1];
            newGreen = Math.min(red, blue) + costs[i-1][2];
            red = newRed;
            blue = newBlue;
            green = newGreen;
        }
        return getMinimum(red, blue, green);
    }
    private int getMinimum(int... colors){
        int min = Integer.MAX_VALUE;
        for(int color:colors){
            min = Math.min(min, color);
        }
        return min;
    }
}
