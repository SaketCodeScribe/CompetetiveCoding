package com.dsa_algorithms.Graph.DjisktraAlgo;

import java.util.*;

public class MinCostToReachCitiesWithDiscount {
    static class Pair<K, V>{
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
    public int minimumCost(int n, int[][] highways, int discounts) {
        int i;
        PriorityQueue<Pair<Pair<Integer, Integer>, Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
        boolean[][] vis = new boolean[n][discounts+1];
        List<List<int[]>> adj = new ArrayList<>();

        for(i=0; i<n; i++)
            adj.add(new ArrayList<>());
        for(int[] highway:highways){
            adj.get(highway[0]).add(new int[]{highway[1], highway[2]});
            adj.get(highway[1]).add(new int[]{highway[0], highway[2]});
        }
        pq.add(new Pair<>(new Pair(0, discounts), 0));

        while(!pq.isEmpty()){
            Pair<Pair<Integer, Integer>, Integer> pair = pq.poll();
            int node = pair.getKey().getKey();
            int discount = pair.getKey().getValue();
            int cost = pair.getValue();
            if (vis[node][discount])
                continue;
            vis[node][discount] = true;
            if (node == n-1)
                return cost;
            for(int[] child:adj.get(node)){
                if (!vis[child[0]][discount]){
                    pq.add(new Pair<>(new Pair<>(child[0], discount), cost+child[1]));
                    if (discount > 0)
                        pq.add(new Pair<>(new Pair<>(child[0], discount-1), cost+child[1]/2));
                }
            }
        }
        return -1;
    }
}
