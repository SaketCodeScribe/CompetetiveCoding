package com.dsa_algorithms.Hash;

import java.util.*;

public class MinSwapsToMakeIdenticalArray {
    public static int minimumSwaps(int n, int[] a, int[] b) {
        // Write your code here.
        int i = 0, j, val, ans = 0;
        TreeMap<Integer, Stack<Integer>> map = new TreeMap<>();

        for (i = 0; i < n; i++) {
            map.putIfAbsent(a[i], new Stack<>());
            map.get(a[i]).push(i);
        }
        for (i = 0; i < n; i++) {
            b[i] = map.get(b[i]).pop();
        }
        i = 0;
        while(i<n){
            j = b[i];
            int next;
            while(j != i){
                next = b[j];
                b[j] = j;
                j = next;
                ans++;
            }
            b[j] = i;
            i++;
        }
        return ans;
    }
}
