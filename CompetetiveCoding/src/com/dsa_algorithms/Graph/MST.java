package com.dsa_algorithms.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MST {
    public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
        int ans = 0;
        boolean[] vis = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        List<List<int[]>> adjacency = new ArrayList<>();
        for(int i=0; i<n; i++)
            adjacency.add(new ArrayList<>());
        for(ArrayList<Integer> edge:edges) {
            adjacency.get(edge.get(0)).add(new int[]{edge.get(1), edge.get(2)});
            adjacency.get(edge.get(1)).add(new int[]{edge.get(0), edge.get(2)});
        }
        pq.add(new int[]{0, 0});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            if (vis[node[0]])
                continue;
            for(int[] child:adjacency.get(node[0]))
                pq.add(child);
            vis[node[0]] = true;
            ans += node[1];
        }
        return ans;
    }
}
