package com.dsa_algorithms.Graph;

import java.util.Arrays;
import java.util.*;
import java.util.stream.IntStream;

public class NumberofOperationstoMakeNetworkConnected {
    int[] par;
    int[] size;
    public int makeConnected(int n, int[][] connections) {
        par = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);
        IntStream.range(0, n).forEach(i -> par[i] = i);
        int edges = connections.length, disconnectedComponent = 0;
        if (edges < n - 1)
            return -1;
        for (int[] connection : connections) {
            union(connection[0], connection[1]);
        }

        for (int i = 0; i < n; i++) {
            if (par[i] == i)
                disconnectedComponent++;
        }
        return --disconnectedComponent;
    }

    private boolean union(int a, int b) {
        int parA, parB, sizeA, sizeB;
        parA = findPar(a);
        parB = findPar(b);
        sizeA = size[parA];
        sizeB = size[parB];
        if(parA == parB)
            return false;
        if (sizeA < sizeB) {
            par[parA] = parB;
            size[parB] += sizeA;
        }
        else{
            par[parB] = parA;
            size[parA] += sizeB;
        }
        return true;
    }

    private int findPar(int a) {
        if (a == par[a])
            return a;
        return par[a] = findPar(par[a]);
    }
}
