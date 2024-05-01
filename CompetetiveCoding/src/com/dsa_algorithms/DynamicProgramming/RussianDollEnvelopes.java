package com.dsa_algorithms.DynamicProgramming;

import java.util.*;
public class RussianDollEnvelopes {
    static class Asc implements Comparator<int[]>{
        @Override
        public int compare(int[] a, int[] b){
            return a[0] != b[0] ? a[0]-b[0] : b[1]-a[1];
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        int i, n = envelopes.length, ans = 0;
        Arrays.sort(envelopes,new Asc());
        List<Integer> arr = new ArrayList<>();
        for(i=0; i<n; i++){
            int j = Collections.binarySearch(arr,envelopes[i][1],Integer::compare);
            j = j < 0 ? -(j+1) : j;
            if (j == arr.size())
                arr.add(envelopes[i][1]);
            else
                arr.set(j, envelopes[i][1]);
        }
        return arr.size();
    }
}
