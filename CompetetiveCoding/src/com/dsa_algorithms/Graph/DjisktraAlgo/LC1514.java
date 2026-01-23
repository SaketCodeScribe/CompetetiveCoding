package com.dsa_algorithms.Graph.DjisktraAlgo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC1514 {
    static class Node implements Comparable<Node>{
        int vertice;
        double prob;
        public Node(int v, double p){
            vertice = v;
            prob = p;
        }
        @Override
        public int compareTo(Node other){
            return Double.compare(other.prob, this.prob);
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Node>> adj = new ArrayList<>();
        initialize(n, edges, succProb, adj);

        return findMaxProbability(adj, start_node, end_node, n);
    }
    private void initialize(int n, int[][] edges, double[] prob, List<List<Node>> adj){
        int i;
        for(i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(i=0; i<edges.length; i++){
            adj.get(edges[i][0]).add(new Node(edges[i][1], prob[i]));
            adj.get(edges[i][1]).add(new Node(edges[i][0], prob[i]));
        }
    }
    private double findMaxProbability(List<List<Node>> adj, int src, int dst, int n){
        PriorityQueue<Comparable> pq = new PriorityQueue<>();
        double[] probability = new double[n];
        probability[src] = 1;
        pq.offer(new Node(src, 1));

        while(!pq.isEmpty()){
            Node node = (Node)pq.poll();
            if (node.prob < probability[node.vertice]){
                continue;
            }
            if (node.vertice == dst){
                return node.prob;
            }
            for (Node child:adj.get(node.vertice)){
                if (probability[child.vertice] < node.prob*child.prob){
                    probability[child.vertice] = node.prob*child.prob;
                    pq.offer(new Node(child.vertice, probability[child.vertice]));
                }
            }
        }
        return 0;
    }
}
