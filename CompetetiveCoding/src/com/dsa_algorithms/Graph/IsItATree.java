package com.dsa_algorithms.Graph;

import java.util.*;
public class IsItATree {
    static boolean[] vis;
    public static boolean isTree(ArrayList<ArrayList<Integer>> adj, int V) {
        // Write your code here.
        if (!isTree(0, -1, adj))
            return false;
        for(int i=0; i<V; i++)
            if (!vis[i])
                return false;
        return true;

    }

    public static boolean isTree(int node, int par, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;

        for(int child : adj.get(node)){
            if (child == par)
                continue;
            if (vis[child])
                return false;
            if (!isTree(child, node, adj))
                return false;
        }
        return true;
    }
}
