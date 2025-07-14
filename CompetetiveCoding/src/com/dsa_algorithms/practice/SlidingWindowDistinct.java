package com.dsa_algorithms.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class SlidingWindowDistinct {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int k = Integer.parseInt(first[1]);

        String[] tokens = br.readLine().split(" ");
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        printDistinctValues(arr, n, k);
    }

    private static void printDistinctValues(long[] seq, int n, int k) {
        Map<Long, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(seq[i], map.getOrDefault(seq[i], 0)+1);
            if (i >= k-1){
                System.out.print(map.size()+" ");
                long key = seq[i - k + 1];
                Integer val = map.get(key);
                if (val > 1) {
                    map.put(key, val - 1);
                }
                else{
                    map.remove(key);
                }
            }
        }
    }
}
