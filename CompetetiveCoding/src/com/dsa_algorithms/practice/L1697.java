package com.dsa_algorithms.practice;

import java.util.Arrays;
import java.util.Comparator;

public class L1697 {
    int[] par;
    int[] size;
    public static void main(String[] args) {

    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] query) {
        int i=0, j=0, edgeLength = edgeList.length, queryLength = query.length;
        int[][] queries = new int[queryLength][];
        boolean[] ans = new boolean[queryLength];
        par = new int[n];
        size = new int[n];
        for(i=0; i<n; i++){
            par[i] = i;
            size[i] = i;
        }
        i = 0;
        for(int[] q:query){
            queries[i] = new int[4];
            j = 0;
            for(int ele:q){
                queries[i][j++] = ele;
            }
            queries[i][j] = i++;
        }
        Arrays.sort(edgeList, getComparator());
        Arrays.sort(queries, getComparator());
        i = j = 0;
        while(j < queryLength){
            while (i < edgeLength && edgeList[i][2] < queries[j][2]){
                union(edgeList[i][0], edgeList[i][1]);
                i++;
            }
            if (findParent(queries[j][0]) == findParent(queries[j][1])){
                ans[queries[j][3]] = true;
            }
            j++;
        }
        return ans;
    }
    private int findParent(int a){
        if (a == par[a]){
            return a;
        }
        return par[a] = findParent(par[a]);
    }
    private void union(int a, int b){
        int parA = findParent(a), parB = findParent(b), sA, sB;
        if (parA == parB){
            return;
        }
        sA = size[parA];
        sB = size[parB];
        if (sA < sB) {
            par[parA] = parB;
            size[parB] += sA;
        }
        else{
            par[parB] = parA;
            size[parA] += sB;
            }
    }

    private static Comparator<int[]> getComparator() {
        return (a, b) -> Integer.compare(a[2], b[2]);
    }
}
