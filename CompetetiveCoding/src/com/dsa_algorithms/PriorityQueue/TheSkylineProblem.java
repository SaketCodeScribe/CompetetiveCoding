package com.dsa_algorithms.PriorityQueue;

import java.util.*;
import java.util.stream.IntStream;

public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        List<List<Integer>> cord = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int i, currHt = 0, n = buildings.length;
        pq.add(0);

        IntStream.range(0, n).forEach(a -> {
            cord.add(Arrays.asList(buildings[a][0], -buildings[a][2]));
            cord.add(Arrays.asList(buildings[a][1], buildings[a][2]));
        });

        Collections.sort(cord, (a,b) -> {
            if(Integer.compare(a.get(0), b.get(0)) == 0)
                return Integer.compare(a.get(1), b.get(1));
            return Integer.compare(a.get(0), b.get(0));
        });

        n = cord.size();
        for(i=0; i<n; i++){
            if (cord.get(i).get(1) < 0)
                pq.add(-cord.get(i).get(1));
            else
                pq.remove(cord.get(i).get(1));
            if (currHt != pq.peek()){
                currHt = pq.peek();
                ans.add(Arrays.asList(cord.get(i).get(0), currHt));
            }
        }
        return ans;
    }
}
