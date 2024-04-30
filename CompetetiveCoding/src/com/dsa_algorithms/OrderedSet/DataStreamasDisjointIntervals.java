package com.dsa_algorithms.OrderedSet;

import java.util.*;
public class DataStreamasDisjointIntervals {
    TreeSet<Integer> tree;
    public DataStreamasDisjointIntervals() {
        tree = new TreeSet<>();
    }

    public void addNum(int value) {
        tree.add(value);
    }

    public int[][] getIntervals() {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        Iterator<Integer> it = tree.iterator();
        int prev = -1, min = -1, max = -1;
        while(it.hasNext()){
            if (prev == -1)
                prev = min = max = it.next();
            else{
                int val = it.next();
                if (prev+1 == val){
                    max = val;
                    prev++;
                }
                else{
                    ans.add(Arrays.asList(min, max));
                    prev = min = max = val;
                }
            }
        }
        if (min != -1)
            ans.add(Arrays.asList(min, max));
        int[][] res = new int[ans.size()][2];
        for(i = 0; i<ans.size(); i++){
            res[i][0] = ans.get(i).get(0);
            res[i][1] = ans.get(i).get(1);
        }
        return res;
    }
}
