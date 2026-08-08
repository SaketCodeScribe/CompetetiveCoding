package com.dsa_algorithms.Graph;

import java.util.*;

public class LC266 {

    public String alienOrder(String[] words) {
        return topologicalOrdering(createGraph(words));
    }
    private Map<Character, List<Character>> createGraph(String[] words) {
        Map<Character, List<Character>> map = new HashMap<>();
        int i, j, n = words.length;
        for(i=0; i<n; i++) {
            for(char ch:words[i].toCharArray()) {
                map.putIfAbsent(ch, new ArrayList<>());
            }
            if (i > 0){
                String curr = words[i], prev = words[i-1];
                int c = words[i].length(), p = words[i-1].length();
                boolean flag = false;
                for(j=0; j<Math.max(c, p); j++){
                    if (p > c && j >= c && !flag) return null;
                    if (j < c) map.putIfAbsent(curr.charAt(j), new ArrayList<>());
                    if (j < p) map.putIfAbsent(prev.charAt(j), new ArrayList<>());
                    if (j < c && j < p) {
                        if (!flag && curr.charAt(j) != prev.charAt(j)) {
                            map.get(prev.charAt(j)).add(curr.charAt(j));
                            flag = true;
                        }
                    }
                }
            }
        }
        return map;
    }
    private String topologicalOrdering(Map<Character, List<Character>> graph) {
        if (graph == null) return "";
        int i;
        int[] counts = new int[26];
        Queue<Character> queue = new LinkedList<>();

        for(List<Character> chars:graph.values()) {
            for(Character ch:chars) {
                counts[ch-'a']++;
            }
        }
        for(i=0; i<26; i++) {
            if (counts[i] == 0 && graph.containsKey((char)(i+'a'))) {
                queue.offer((char)(i+'a'));
            }
        }

        if (queue.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            char ch = queue.poll();
            sb.append(ch);
            for(char nextCh:graph.get(ch)) {
                int cnt = --counts[nextCh-'a'];
                if (cnt == 0) {
                    queue.offer(nextCh);
                }
            }
        }
        for(int cnt:counts) { if (cnt > 0) return "";};
        return sb.toString();
    }
}
