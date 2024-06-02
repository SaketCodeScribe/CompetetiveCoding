package com.dsa_algorithms.Graph;
import java.util.*;

public class BipartiteGraph {
    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {
        // Write your code here
        int i, j, n = edges.size();
        List<List<Integer>> adj = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        int[] col = new int[n];
        for(i=0; i<n; i++)
            adj.add(new ArrayList<>());

        for(i=0; i<n; i++){
            for(j=0; j<n; j++){
                if (edges.get(i).get(j) == 1)
                    adj.get(i).add(j);
            }
        }

        for(i=0; i<n; i++){
            if (col[i] == 0){
                queue.add(Arrays.asList(i,1));
                col[i] = 1;
                while(!queue.isEmpty()){
                    int node = queue.peek().get(0), colr = queue.poll().get(1);
                    for(Integer child:adj.get(node)){
                        if (col[child] == colr)
                            return false;
                        if (col[child] == 0){
                            col[child] = colr == 1 ? 2 : 1;
                            queue.add(Arrays.asList(child, col[child]));
                        }
                    }
                }
            }
        }
        return true;
    }
}
