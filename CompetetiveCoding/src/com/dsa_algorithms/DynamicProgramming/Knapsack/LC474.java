package com.dsa_algorithms.DynamicProgramming.Knapsack;

public class LC474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int i, j, k, l = strs.length;
        int[][] arr = new int[l][];
        initialize(arr, strs, l);
        int[][] dp = new int[m+1][n+1];

        for(k=0; k<l; k++){
            int zeroes = arr[k][0], ones = arr[k][1];
            for(i=m; i>=0; i--){
                for(j=n; j>=0; j--){
                    if (zeroes <= i && ones <= j){
                        dp[i][j] = Math.max(dp[i][j], dp[i-zeroes][j-ones]+1);
                    }
                }
            }
        }
        return dp[m][n];
    }
    private void initialize(int[][] arr, String[] strs, int n){
        int i, j;

        for(i=0; i<n; i++){
            int zeroes = 0, ones = 0;
            for(j=0; j<strs[i].length(); j++){
                if (strs[i].charAt(j) == '0'){
                    zeroes++;
                }
                else{
                    ones++;
                }
            }
            arr[i] = new int[]{zeroes, ones};
        }
    }
}
