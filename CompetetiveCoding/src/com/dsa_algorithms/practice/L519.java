package com.dsa_algorithms.practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class L519 {
    Map<Integer, Integer> map;
    int m, n, total;
    Random rand;
    public L519(int m, int n) {
        map = new HashMap<>();
        this.m = m;
        this.n = n;
        total = m*n;
        rand = new Random();
    }

    public int[] flip() {
        int index = rand.nextInt(total--);
        int value = map.getOrDefault(index, index);
        map.put(index, findNode(map, total));
        return new int[]{value/n, value%n};
    }
    private int findNode(Map<Integer, Integer> map, int node){
        while(!map.containsKey(node)){
            node = map.get(node);
        }
        return node;
    }
    public void reset() {
        total = m*n;
        map.clear();
    }
    public static void main(String[] args) {

    }
}
