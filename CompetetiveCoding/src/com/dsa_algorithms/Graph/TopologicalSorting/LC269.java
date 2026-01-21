package com.dsa_algorithms.Graph.TopologicalSorting;

import java.util.*;

public class LC269 {
    public String alienOrder(String[] words) {
        int i, j, n = words.length;
        int[] indegree = new int[26];
        List<List<Integer>> adj = new ArrayList<>();

        initialize(adj, n, words, indegree);
        if (!createOrdering(words, n, adj, indegree)){
            return "";
        }
        String order = traversal(indegree, adj);
        return alphabetOrdering(words, n, indegree, order);
    }
    private void initialize(List<List<Integer>> adj, int n, String[] words, int[] indegree){
        int i;
        Arrays.fill(indegree, -1);

        for(i=0; i<26; i++){
            adj.add(new ArrayList<>());
        }
    }
    private boolean createOrdering(String[] words, int n, List<List<Integer>> adj, int[] indegree){
        int i, j;
        for(i=0; i<n; i++){
            String word = words[i];
            for(j=0; j<word.length(); j++){
                indegree[word.charAt(j)-'a'] = 0;
            }
        }
        for(i=0; i<n-1; i++){
            String wA = words[i], wB = words[i+1];
            int m = Math.min(wA.length(), wB.length());
            for(j=0; j<m; j++){
                if (wA.charAt(j) != wB.charAt(j)){
                    indegree[wB.charAt(j)-'a'] = indegree[wB.charAt(j)-'a']+1;
                    adj.get(wA.charAt(j)-'a').add(wB.charAt(j)-'a');
                    break;
                }
            }
            if (wA.length() > wB.length() && j == m){
                return false;
            }
        }
        return true;
    }
    private String traversal(int[] indegree, List<List<Integer>> adj){
        int i;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        for(i=0; i<26; i++){
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int node = queue.poll();
                sb.append((char)(node + 'a'));
                for(int child:adj.get(node)){
                    indegree[child]--;
                    if (indegree[child] == 0){
                        queue.offer(child);
                    }
                }
            }
        }
        return sb.toString();
    }
    private String alphabetOrdering(String[] words, int n, int[] indegree, String order){
        int i, j;
        for(i=0; i<n; i++){
            String word = words[i];
            for(j=0; j<word.length(); j++){
                if (indegree[word.charAt(j)-'a'] > 0){
                    return "";
                }
            }
        }
        return order;
    }
}
