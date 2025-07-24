package com.dsa_algorithms.practice;

public class L418_Greedy {
    /**
     * T.C: O(rows + n)
     * @param sentence
     * @param rows
     * @param cols
     * @return
     */

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int nextCursorX = 0, nextCursorY = 0, ans = 0, len = 0;

        for(String word:sentence){
            if (word.length() > cols){
                return 0;
            }
            len += word.length()+1;
        }

        while(nextCursorX < rows){
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
            if (nextCursorX <= rows && nextCursorY == 0){
                ans++;
            }
            else if (nextCursorX < rows){
                int remLength = cols - nextCursorY;
                ans += remLength / len + 1;
                nextCursorY += (remLength / len) * len;
            }
        }

        return ans;
    }
}
