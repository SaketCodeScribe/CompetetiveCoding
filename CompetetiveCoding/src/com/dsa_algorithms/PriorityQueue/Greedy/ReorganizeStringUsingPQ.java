package com.dsa_algorithms.PriorityQueue.Greedy;

import java.util.*;
public class ReorganizeStringUsingPQ {
    static class Pair<K,V>{
        private K key;
        private V value;
        Pair(K k, V v){
            key = k; value = v;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
    public String reorganizeString(String s) {
        int i, j, n = s.length();
        int[] count = new int[26];
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.getValue(), a.getValue()));

        for(char ch:s.toCharArray())
            count[ch-'a']++;
        for(i=0; i<26; i++){
            if (count[i] > 0)
                pq.add(new Pair<>((char)(i+'a'), count[i]));
        }

        while(!pq.isEmpty()){
            Pair<Character, Integer> top = pq.poll();
            if (pq.isEmpty() && top.getValue() > 1)
                return "";
            Pair<Character, Integer> top1 = !pq.isEmpty() ? pq.poll() : null;

            sb.append(top.getKey());
            if (top1 != null)
                sb.append(top1.getKey());

            if (top.getValue()-1 > 0)
                pq.add(new Pair<>(top.getKey(), top.getValue()-1));

            if (top1 != null && top1.getValue()-1 > 0)
                pq.add(new Pair<>(top1.getKey(), top1.getValue()-1));
        }

        return sb.toString();
    }
}
