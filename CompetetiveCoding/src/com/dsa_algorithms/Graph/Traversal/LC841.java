package com.dsa_algorithms.Graph.Traversal;

import java.util.List;

public class LC841 {
    int cnt;
    boolean[] vis;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int i, n = rooms.size();
        vis = new boolean[n];

        return n == dfs(0, rooms);
    }
    private int dfs(int node, List<List<Integer>> rooms){
        vis[node] = true;
        int cnt = 1;
        for(int roomKey:rooms.get(node)){
            if (!vis[roomKey]){
                cnt += dfs(roomKey, rooms);
            }
        }
        return cnt;
    }
}
