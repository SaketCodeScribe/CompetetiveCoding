package com.dsa_algorithms.Contest.weekly.weekly458;

public class Solution2 {
    int[] par, size;
    public int minCost(int n, int[][] edges, int k) {
        int low = 1, high = Integer.MAX_VALUE, ans = 0, mid;

        while(low <= high){
            mid = low + (high-low)/2;
            if (getComponents(edges, n, mid) > k){
                low = mid+1;
            }
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
    private int getComponents(int[][]edges, int n, int wt){
        int i, component = 0;
        par = new int[n];
        size = new int[n];
        for(i=0; i<n; i++){
            par[i] = i;
            size[i] = 1;
        }
        for(int[] edge:edges){
            if (edge[2] < wt){
                union(edge[0], edge[1]);
            }
        }
        for(i=0; i<n; i++){
            if (i == findParent(i)){
                component++;
            }
        }
        return component;
    }

    private void union(int a, int b) {
        int parA = findParent(a), parB = findParent(b);
        if (parA == parB){
            return;
        }
        int sA = size[parA], sB = size[parB];
        if (sA < sB){
            par[parA] = parB;
            size[parB] += sA;
        }
        else{
            par[parB] = parA;
            size[parA] += sB;
        }
    }

    private int findParent(int a) {
        if (a == par[a]){
            return a;
        }
        return par[a] = findParent(par[a]);
    }
}
