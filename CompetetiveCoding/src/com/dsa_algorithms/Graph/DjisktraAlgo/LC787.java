package com.dsa_algorithms.Graph.DjisktraAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        initialize(n, flights, adj);

        return cheapestFlight(src, dst, k+1, n, adj);
    }
    private void initialize(int n, int[][] flights, List<List<int[]>> adj){
        int i;
        for(i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight:flights){
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
    }
    private int cheapestFlight(int src, int dst, int stops, int n, List<List<int[]>> adj){
        int[][] prices = new int[n][stops+1];
        int cheapestPrice = Integer.MAX_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        for(int i=0; i<n; i++){
            Arrays.fill(prices[i], Integer.MAX_VALUE);
        }
        prices[src][stops] = 0;

        pq.offer(new int[]{src, stops, 0});

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            assert top != null;
            int node = top[0], stop = top[1], priceTillNode = top[2];
            if (prices[node][stop] < priceTillNode){
                continue;
            }
            if (node == dst){
                return priceTillNode;
            }
            for(int[] flight:adj.get(node)){
                int child = flight[0], price = flight[1];
                if (stop > 0 && prices[child][stop-1] > priceTillNode + price){
                    prices[child][stop-1] = priceTillNode + price;
                    pq.offer(new int[]{child, stop-1, priceTillNode + price});
                }
            }
        }
        return -1;
    }
}
