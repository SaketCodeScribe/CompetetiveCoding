package com.dsa_algorithms.SlidingWindow;

import java.util.*;
public class KDistinctSubarrays {
    public static int kDistinctSubarrays(int[] arr, int n, int k) {
        // Write your code here.
        return atMostKDistSubArray(arr, n, k)-atMostKDistSubArray(arr, n, k-1);
    }
    public static int atMostKDistSubArray(int[] arr, int n, int k){
        int i=0, j=0, ans = 0;
        Map<Integer, Integer> freq = new HashMap();

        while(i < n){
            if (!freq.containsKey(arr[i]))
                k--;
            freq.put(arr[i], freq.getOrDefault(arr[i],0)+1);

            while((j<=i && k < 0)){
                freq.put(arr[j], freq.get(arr[j])-1);
                if (freq.get(arr[j]) == 0){
                    freq.remove(arr[j]);
                    k++;
                }
                j++;
            }
            ans += i-j+1;
            i++;
        }
        return ans;
    }
}
