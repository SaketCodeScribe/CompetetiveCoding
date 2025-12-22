package com.dsa_algorithms.Greedy.ResourceAllocation_Matching;

import java.util.Arrays;
import java.util.TreeMap;

public class LC881 {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length, i, boats = 0;
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        Arrays.sort(people);
        for(int p:people){
            tree.put(p, tree.getOrDefault(p,0)+1);
        }

        for(i=0; i<n; i++){
            if (tree.containsKey(people[i])){
                Integer floorKey = tree.floorKey(limit-people[i]);
                if (floorKey != null && (floorKey != people[i] || tree.get(floorKey) > 1)){
                    if (tree.get(floorKey) == 1){
                        tree.remove(floorKey);
                    }
                    else{
                        tree.put(floorKey, tree.get(floorKey)-1);
                    }
                }
                if (tree.get(people[i]) == 1){
                    tree.remove(people[i]);
                }
                else{
                    tree.put(people[i], tree.get(people[i])-1);
                }
                boats++;
            }
        }
        return boats;
    }
}
