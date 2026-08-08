package com.dsa_algorithms.Graph;

import java.util.*;

public class LC127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        return !wordSet.contains(endWord) ? 0 : shortestTransformation(beginWord, endWord, wordSet);
    }
    private int shortestTransformation(String beginWord, String endWord, Set<String> wordSet) {
        Set<String> vis = new HashSet<>();
        Queue<Map.Entry<String, Integer>> queue = new LinkedList<>();

        queue.offer(Map.entry(beginWord, 1));
        vis.add(beginWord);

        while(!queue.isEmpty()) {
            Map.Entry<String, Integer> entry = queue.poll();
            String curr = entry.getKey();
            int level = entry.getValue();
            if (curr.equals(endWord)) return level;
            char[] chars = curr.toCharArray();
            for(int i=0; i<curr.length(); i++){
                char ch = chars[i];
                for(int c=0; c<26; c++) {
                    chars[i] = (char)(c + 'a');
                    String temp = new String(chars);
                    chars[i] = ch;
                    if (vis.contains(temp) || !wordSet.contains(temp)) continue;
                    vis.add(temp);
                    queue.offer(Map.entry(temp, level+1));
                }
            }
        }
        return 0;
    }

    // using bidirectional BFS

    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        return !wordSet.contains(endWord) ? 0 : shortestTransformation(beginWord, endWord, wordSet);
    }
    private int shortestTransformation1(String beginWord, String endWord, Set<String> wordSet) {
        Set<String> vis = new HashSet<>(List.of(beginWord, endWord));
        Set<String> beginSet = new HashSet<>(List.of(beginWord));
        Set<String> endSet = new HashSet<>(List.of(endWord));
        int level = 1;


        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
                continue;
            }
            Set<String> nextSet = new HashSet<>();
            for(String word:beginSet) {
                char[] chars = word.toCharArray();
                for(int i=0; i<chars.length; i++) {
                    char ch = chars[i];
                    for(int c=0; c<26; c++) {
                        chars[i] = (char)(c + 'a');
                        String nextWord = new String(chars);
                        chars[i] = ch;
                        if (endSet.contains(nextWord)) return level+1;
                        if (vis.contains(nextWord) || !wordSet.contains(nextWord)) continue;
                        nextSet.add(nextWord);
                        vis.add(nextWord);
                    }
                }
            }
            beginSet = nextSet;
            level++;
        }
        return 0;
    }
}
