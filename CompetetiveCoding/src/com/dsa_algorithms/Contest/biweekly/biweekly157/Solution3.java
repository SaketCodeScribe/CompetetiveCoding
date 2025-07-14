package com.dsa_algorithms.Contest.biweekly.biweekly157;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution3 {
    public static void main(String[] args) {

    }
    public int assignEdgeWeights(int[][] edges) {
        int i, n = edges.length+1;
        List<List<Integer>> adj = new ArrayList<>();
        for(i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            adj.get(e[0]-1).add(e[1]-1);
        }
        int depth = findDepth(adj, 0);
        int odd = 1, even = 1;

        for(i=2; i<=depth; i++){
            int temp = odd;
            odd = even+odd;
            even = temp+even;
        }
        return odd;
    }
    private int findDepth(List<List<Integer>> adj, int root){
        int depth = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            while(size-- > 0){
                for(int child:adj.get(queue.poll())){
                    queue.offer(child);
                }
            }
        }
        return depth-1;
    }
}
