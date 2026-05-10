package com.dsa_algorithms.Array.PrefixSuffix;

public class LC3234 {

    public int numberOfSubstrings(String s) {
        int i, cnt = 0, n = s.length(), lastZeroIndex = 0, totalOnesSoFar = 0;
        int[] previousZero = new int[n+1];
        previousZero[0] = lastZeroIndex;

        // 1-index
        for(i=1; i<=n; i++){
            int bit = s.charAt(i-1)-'0';
            previousZero[i] = lastZeroIndex;
            if (bit == 1){
                totalOnesSoFar++;
                cnt += noOfSubstrings(previousZero, i, previousZero[i], false, totalOnesSoFar);
            }
            else{
                cnt += noOfSubstrings(previousZero, i, previousZero[i], true, totalOnesSoFar);
                lastZeroIndex = i;
            }
        }
        return cnt;
    }

    private int noOfSubstrings(int[] previousZero, int curr, int lastZeroIndex, boolean isCurrZero, int totalOnesSoFar){
        int zeroes, ones, cnt = 0, noOfSubstrings;
        if (isCurrZero){
            zeroes = 1;
            ones = noOfSubstrings = curr - lastZeroIndex - 1;
        }
        else{
            ones = noOfSubstrings = curr - lastZeroIndex;
            zeroes = 0;
        }

        while(totalOnesSoFar >= zeroes * zeroes){
            if (ones >= zeroes*zeroes){
                cnt += noOfSubstrings;
            }
            if (lastZeroIndex == 0) break;
            zeroes++;
            int gapBetweenSuccessiveZero = lastZeroIndex - previousZero[lastZeroIndex];
            int minOnesRequired = Math.max(0, zeroes * zeroes - ones);
            noOfSubstrings = gapBetweenSuccessiveZero - minOnesRequired;
            ones += gapBetweenSuccessiveZero - 1;
            lastZeroIndex = previousZero[lastZeroIndex];
        }
        return cnt;
    }
}
