package com.dsa_algorithms.Graph.GraphTheory;

public class LC758 {
    public boolean isBipartite(int[][] graph) {
        int i, n = graph.length;
        int[] colors = new int[n];
        for(i=0; i<n; i++){
            if (colors[i] == 0 && !traverse(i, graph, colors, 1)){
                return false;
            }
        }
        return true;
    }
    private boolean traverse(int node, int[][] graph, int[] colors, int color){
        colors[node] = color;

        for(int child:graph[node]){
            if (colors[node] == colors[child] || (colors[child] == 0 && !traverse(child, graph, colors, color == 1 ? 2 : 1))){
                return false;
            }
        }
        return true;
    }
}
