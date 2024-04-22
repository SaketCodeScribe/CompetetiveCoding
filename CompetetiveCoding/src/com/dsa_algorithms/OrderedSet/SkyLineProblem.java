package com.dsa_algorithms.OrderedSet;

import java.util.*;

public class SkyLineProblem {
    static class Pair{
        int cord;
        int ht;
        boolean isEnd;
        Pair(int cord, int ht, boolean isEnd){
            this.cord = cord;
            this.ht = ht;
            this.isEnd = isEnd;
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans= new ArrayList<>();
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        List<Pair> arr = new ArrayList<>();
        for(int[] building:buildings){
            arr.add(new Pair(building[0], building[2], false));
            arr.add(new Pair(building[1], building[2], true));
        }
        Collections.sort(arr, (a,b) -> a.cord != b.cord ? a.cord-b.cord :
                (!a.isEnd && !b.isEnd ? b.ht-a.ht : (a.isEnd && b.isEnd ? a.ht - b.ht : (a.isEnd ? 1 : -1))));
        int i, n = arr.size();
        for(i=0; i<n; i++){
            int cord = arr.get(i).cord;
            int ht = arr.get(i).ht;
            boolean isEnd = arr.get(i).isEnd;
            if (!isEnd){
                if (tree.isEmpty() || tree.lastKey() < ht)
                    ans.add(Arrays.asList(cord, ht));
                tree.put(ht, tree.getOrDefault(ht,0)+1);
            }
            else{
                tree.put(ht, tree.get(ht)-1);
                int last = tree.lastKey();
                int cnt = tree.get(ht);
                if (cnt == 0){
                    tree.remove(ht);
                    if (ht == last){
                        ht = tree.isEmpty() ? 0 : tree.lastKey();
                        ans.add(Arrays.asList(cord, ht));
                    }
                }
            }
        }
        return ans;
    }
}
