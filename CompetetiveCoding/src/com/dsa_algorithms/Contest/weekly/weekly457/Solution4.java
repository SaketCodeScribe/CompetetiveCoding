package com.dsa_algorithms.Contest.weekly.weekly457;

import java.util.*;
public class Solution4 {
    int[] par;
    int[] size;

    public int minTime(int n, int[][] edges, int k) {
        int i, time = 0;
        par = new int[n];
        size = new int[n];

        for(i=0; i<n; i++){
            par[i] = i;
            size[i] = 1;
        }
        for (int[] edge:edges){
            union(edge[0], edge[1]);
            time = Math.max(time, edge[2]);
        }
        if (getComponents(n) >= k){
            return 0;
        }
        int low = 0, mid, high = time, ans = 0;

        while(low<=high){
            mid = low+(high-low)/2;
            int comp = getK(n, edges, mid);
            if (comp >= k){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    private int getComponents(int n) {
        int i, cnt = 0;
        for(i=0; i< n; i++){
            if (i == findPar(i)){
                cnt++;
            }
        }
        return cnt;
    }

    private int getK(int n, int[][] edges, int time) {
        par = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            par[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            if (edge[2] > time) {
                union(edge[0], edge[1]);
            }
        }
        return getComponents(n);
    }

    public int findPar(int a){
        if (a == par[a])
            return a;
        return par[a] = findPar(par[a]);
    }

    public void union(int a, int b){
        int parA = findPar(a), parB = findPar(b), sizeA, sizeB;
        if (parA == parB){
            return;
        }
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
    public static void main(String[] args) {
        Solution4 obj = new Solution4();
        System.out.println(obj.minTime(4, new int[][]{{2,0,5025},{3,1,7459},{2,3,15995}}, 2));
    }
}
