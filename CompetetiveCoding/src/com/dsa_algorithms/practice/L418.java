package com.dsa_algorithms.practice;

import java.util.Arrays;

public class L418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int i, j, len = 0, ans = 0;
        int[][] dp = new int[rows][cols];

        for(String word:sentence){
            len += word.length()+1;
        }

        for(i=0; i<rows; i++){
            for(j=0; j<cols; j++){
                dp[i][j] = j + len + 1;
            }
        }
        i = j = 0;
        while(i < rows && j < cols){
            int nextCursorX = dp[i][j]/cols;
            int nextCursorY = dp[i][j]%cols;
            ans++;
            i = nextCursorX;
            j = nextCursorY;
        }
        return i < rows && j == cols ? ans : ans-1;
    }
}
