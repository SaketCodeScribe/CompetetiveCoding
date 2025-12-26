package com.dsa_algorithms.Graph.Traversal;

import java.util.*;

public class LC1129 {

    private static final int RED = 0;
    private static final int BLUE = 1;
    private static final int INF = Integer.MAX_VALUE;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] answer = new int[n];
        Arrays.fill(answer, INF);
        List<List<Integer>> red = buildGraph(n, redEdges);
        List<List<Integer>> blue = buildGraph(n, blueEdges);

        bfs(n, red, blue, RED, answer);
        bfs(n, red, blue, BLUE, answer);
        answer[0] = 0;
        for (int i = 0; i < n; i++) {
            if (answer[i] == INF) answer[i] = -1;
        }
        return answer;
    }
    private List<List<Integer>> buildGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) graph.get(e[0]).add(e[1]);
        return graph;
    }
    private void bfs(int n, List<List<Integer>> red, List<List<Integer>> blue, int startColor, int[] answer) {
        int[][] dist = new int[n][2];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], INF);
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        dist[0][0] = dist[0][1] = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int prevColor = startColor == 0 ? 1 : 0;
            while(size-- > 0){
                int node = queue.poll();
                answer[node] = Math.min(answer[node], dist[node][prevColor]);
                for(int child:(startColor == 0 ? red.get(node) : blue.get(node))){
                    if (dist[child][startColor] > dist[node][prevColor]+1){
                        dist[child][startColor] = dist[node][prevColor]+1;
                        queue.offer(child);
                    }
                }
            }
            startColor = startColor == 0 ? 1 : 0;
        }
    }
}
