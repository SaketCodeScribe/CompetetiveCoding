package com.dsa_algorithms.Graph;

import java.util.stream.IntStream;

public class CycleDetection {
    static int[] par;
    static int[] size;

    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        par = new int[n+1];
        size = new int[n+1];
        IntStream.range(1, n+1).forEach(i -> {par[i] = i; size[i] = 1;});
        for(int[] edge:edges){

            if (findPar(edge[0]) == findPar(edge[1]))
                return "Yes";
            union(edge[0], edge[1]);
        }
        return "No";
    }
    public static void union(int a, int b){
        int parA = findPar(a), parB = findPar(b), sizeA, sizeB;
        sizeA = size[parA];
        sizeB = size[parB];
        if (sizeA > sizeB){
            par[parB] = parA;
            size[parA] += size[parB];
        }
        else{
            par[parA] = parB;
            size[parB] += size[parA];
        }
    }
    public static int findPar(int a){
        if (a == par[a])
            return a;
        return par[a] = findPar(par[a]);
    }
}
