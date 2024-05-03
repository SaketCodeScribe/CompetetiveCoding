package com.dsa_algorithms.Set;

import java.util.*;
public class InsertDeleteGetRandomDuplicatesallowed {
    List<Integer> arr;
    Map<Integer, Set<Integer>> map;
    Random rand;

    public InsertDeleteGetRandomDuplicatesallowed() {
        arr = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val))
            map.put(val, new HashSet<>());
        map.get(val).add(arr.size());
        arr.add(val);
        return map.get(val).size() == 1;

    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty())
            return false;
        int n = arr.size();
        int last = arr.get(n-1);
        int remidx = map.get(val).iterator().next();
        map.get(val).remove(remidx);
        arr.set(remidx, last);
        map.get(last).add(remidx);
        map.get(last).remove(n-1);
        arr.remove(n-1);
        return true;
    }

    public int getRandom() {
        return arr.get(rand.nextInt(arr.size()));
    }
}
