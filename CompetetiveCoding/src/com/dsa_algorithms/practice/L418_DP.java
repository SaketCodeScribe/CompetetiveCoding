package com.dsa_algorithms.practice;

public class L418_DP {
    /**
     * T.C: O(row*col)
     */
    class Cursor{
        int x, y;
        public Cursor(int i, int j){
            x = i;
            y = j;
        }
    }
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int i, j, ans = 0;
        Cursor[] dp = new Cursor[cols];

        for(String word:sentence){
            if (word.length() > cols){
                return 0;
            }
        }

        for(j=0; j<cols; j++){
            int nextCursorX = 0, nextCursorY = j;
            for(String word:sentence){
                if (word.length()+nextCursorY-1 < cols){
                    nextCursorY += word.length();
                }
                else{
                    nextCursorY = word.length();
                    nextCursorX++;
                }
                nextCursorY++;
                if (nextCursorY >= cols){
                    nextCursorX++;
                    nextCursorY = 0;
                }
            }
            dp[j] = new Cursor(nextCursorX, nextCursorY);
        }

        i = j = 0;
        while(i < rows && j < cols){
            int nextCursorX = dp[j].x;
            int nextCursorY = dp[j].y;
            ans++;
            i += nextCursorX;
            j = nextCursorY;
        }
        return i == rows && j == 0 ? ans : ans-1;
    }
}
