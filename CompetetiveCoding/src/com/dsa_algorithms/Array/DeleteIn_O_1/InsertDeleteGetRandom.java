package com.dsa_algorithms.Array.DeleteIn_O_1;

import java.util.*;
public class InsertDeleteGetRandom {
    List<Integer> arr;
    Map<Integer, Integer> map;

    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        arr = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val,arr.size());
        arr.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int i = map.get(val);
        if (i < arr.size()-1){
            arr.set(i, arr.get(arr.size()-1));
            map.put(arr.get(i), i);
        }
        arr.remove(arr.size()-1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        Random rand = new Random();
        int random = rand.nextInt(arr.size());
        return arr.get(random);
    }
}
