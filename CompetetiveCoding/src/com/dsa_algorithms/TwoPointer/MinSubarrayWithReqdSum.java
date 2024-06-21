package com.dsa_algorithms.TwoPointer;

import java.util.*;
public class MinSubarrayWithReqdSum {
    public static ArrayList<Integer> minSubarray(ArrayList<Integer> arr, int n, int x)
    {
        // Write your code here
        int i=0, j=0;
        long sum = 0;
        int[] ind = new int[2];
        ArrayList<Integer> ans = new ArrayList<>();
        ind[1] = Integer.MAX_VALUE-1;

        while(i < n){
            sum += arr.get(i);
            while(j <= i && sum > x){
                sum -= arr.get(j);
                if (sum <= x){
                    if (i-j+1 < ind[1]-ind[0]+1){
                        ind[0] = j;
                        ind[1] = i;
                    }
                }
                j++;
            }
            i++;
        }
        if (ind[1] == Integer.MAX_VALUE-1)
            return ans;
        i = ind[0]; j = ind[1];
        while(i<=j)
            ans.add(arr.get(i++));
        return ans;
    }
}