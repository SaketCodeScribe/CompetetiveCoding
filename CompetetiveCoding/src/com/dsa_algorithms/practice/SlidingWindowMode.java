package com.dsa_algorithms.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class SlidingWindowMode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read n and k
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int k = Integer.parseInt(first[1]);

        // Read the array
        String[] tokens = br.readLine().split(" ");
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(tokens[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> treeSet = new TreeSet<>((a, b) -> {
            Integer val1 = map.getOrDefault(a, 0);
            Integer val2 = map.getOrDefault(b, 0);
            if (val1.equals(val2)){
                return Integer.compare(a,b);
            }
            return Integer.compare(val2, val1);
        });
        int i;

        for(i=0; i<n; i++){
            if (map.containsKey(seq[i])){
                treeSet.remove(seq[i]);
            }
            map.put(seq[i], map.getOrDefault(seq[i], 0)+1);
            treeSet.add(seq[i]);
            if (i >= k-1){
                System.out.print(treeSet.first()+" ");
                treeSet.remove(seq[i-k+1]);
                map.put(seq[i-k+1], map.get(seq[i-k+1])-1);
                if (map.get(seq[i-k+1]) == 0){
                    map.remove(seq[i-k+1]);
                }
                else{
                    treeSet.add(seq[i-k+1]);
                }
            }
        }
    }
}
