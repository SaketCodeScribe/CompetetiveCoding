package com.dsa_algorithms.DynamicProgramming.GeneralMultiDimensional;

import java.util.Arrays;

public class LC265 {
    /*
        T.C - O(n*k*k)
        S.C - O(k)
     */
    public int minCostI(int[][] costs) {
        int n = costs.length, m = costs[0].length, i, j, k, minCost = Integer.MAX_VALUE;
        int[] dp = new int[m], curr = new int[m];

        for(i=1; i<=n; i++){
            for(j=0; j<m; j++){
                curr[j] = Integer.MAX_VALUE;
                for(k=0; k<m; k++){
                    if (j != k){
                        curr[j] = Math.min(curr[j], dp[k] + costs[i-1][j]);
                    }
                }
                if (i == n) minCost = Math.min(minCost, curr[j]);
            }
            if (i < n) dp = Arrays.copyOf(curr, m);
        }
        return minCost;
    }

    /*
        Optimized T.C - O(n*k)
        S.C - O(k)
     */

    public int minCostII(int[][] costs) {
        int n = costs.length, m = costs[0].length, i, j, k, minCost = Integer.MAX_VALUE;
        int[] dp = new int[m], leftMin = new int[m], rightMin = new int[m];

        for(i=1; i<=n; i++){
            for(j=0; j<m; j++){
                dp[j] += costs[i-1][j];
                if (i == n){
                    minCost = Math.min(minCost, dp[j]);
                }
            }
            if (i < n) getMinCostExcludingColor(dp, leftMin, rightMin, m);
        }
        return minCost;
    }
    private void getMinCostExcludingColor(int[] dp, int[] leftMin, int[] rightMin, int n){
        int i;
        leftMin[0] = dp[0];
        rightMin[n-1] = dp[n-1];
        for(i=1; i<n; i++){
            leftMin[i] = Math.min(leftMin[i-1], dp[i]);
        }
        for(i=n-2; i>=0; i--){
            rightMin[i] = Math.min(rightMin[i+1], dp[i]);
        }
        for(i=0; i<n; i++){
            dp[i] = Math.min(i > 0 ? leftMin[i-1] : rightMin[i+1], i < n-1 ? rightMin[i+1] : leftMin[i-1]);
        }
    }


    /*
        Optimized T.C - O(n*k)
        Optimized S.C - O(1), just add current cost with the previousMinCost if colors are diff else secondMinCost
     */

    public int minCostIII(int[][] costs) {
        int n = costs.length, m = costs[0].length, i, j, k, minColor = -1, secondMinColor = -1;

        for(i=0; i<n; i++){
            for(j=0; i>0 && j<m; j++){
                if (j == minColor) costs[i][j] += costs[i-1][secondMinColor];
                else costs[i][j] += costs[i-1][minColor];
            }
            int[] minColors = getMinAndSecondMin(costs[i], m);
            minColor = minColors[0];
            secondMinColor = minColors[1];
        }
        return costs[n-1][minColor];
    }
    private int[] getMinAndSecondMin(int[] arr, int n){
        int i, min = -1, secondMin = -1;

        for(i=0; i<n; i++){
            if (min == -1){
                min = i;
            }
            else if (arr[i] <= arr[min]){
                secondMin = min;
                min = i;
            }
            else if (secondMin == -1 || arr[i] < arr[secondMin]){
                secondMin = i;
            }
        }
        return new int[]{min, secondMin};
    }
}
