package com.dsa_algorithms.Graph.GraphTheory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LC1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];

        for(List<Integer> edge:edges){
            indegree[edge.get(1)]++;
        }

        return IntStream.range(0,n).filter(i -> indegree[i] == 0).boxed().collect(Collectors.toList());
    }
}
