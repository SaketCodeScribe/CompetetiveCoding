package com.dsa_algorithms.Contest.weekly.weekly456;
import java.util.*;
public class Solution4 {
    public static int maxStability(int n, int[][] edges, int k) {
        int i;
        List<List<List<Integer>>> adj = new ArrayList<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.get(1), a.get(1)));
        Integer[] vis = new Integer[n];

        for(i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(List.of(edge[1], edge[2], edge[3]));
            adj.get(edge[1]).add(List.of(edge[0], edge[2], edge[3]));
        }
        int low = 1, high = 2_00_001, mid, ans = -1;

        while (low <= high){
            mid = low + (high-low)/2;
            int calcK = calculate(edges, n, mid);
            if (calcK <= k){
                if (calcK == k){
                    ans = mid;
                }
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }

    private static int calculate(int[][] edges, int n, int tar) {
        return 0;
    }

}
