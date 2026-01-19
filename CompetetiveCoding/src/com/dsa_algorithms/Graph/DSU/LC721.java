package com.dsa_algorithms.Graph.DSU;

import java.util.*;
import java.util.stream.Collectors;

public class LC721 {
    static class DSU{
        private int[] parent, size;

        public DSU(int n){
            parent = new int[n];
            size = new int[n];

            for(int i=0; i<n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int getParent(int node){
            if (parent[node] == node){
                return node;
            }
            return parent[node] = getParent(parent[node]);
        }

        public void union(int nodeA, int nodeB){
            int parA = getParent(nodeA), parB = getParent(nodeB);
            if (nodeA == nodeB){
                return;
            }
            int sizeA = size[parA], sizeB = size[parB];

            if (sizeA > sizeB){
                parent[parB] = parA;
                size[parA] += size[parB];
            }
            else{
                parent[parA] = parB;
                size[parB] += size[parA];
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int i, n;
        Map<String, Integer> mailToId = new HashMap<>();
        Map<Integer, String> idToName = new HashMap<>();
        boolean[] vis;
        Map<Integer, List<String>> nameToMails = new HashMap<>();

        n = initialize(accounts, mailToId);
        DSU dsu = new DSU(n);
        vis = new boolean[n];

        for(List<String> account:accounts){
            for(i=1; i<account.size()-1; i++){
                dsu.union(mailToId.get(account.get(i)), mailToId.get(account.get(i+1)));
            }
        }

        for(List<String> account:accounts){
            String name = account.get(0);
            int parentId = dsu.getParent(mailToId.get(account.get(1)));
            idToName.put(parentId, name);
            for(i=1; i<account.size(); i++){
                String acc = account.get(i);
                int accountId = mailToId.get(account.get(i));
                if (!vis[accountId]){
                    nameToMails.computeIfAbsent(parentId, x -> new ArrayList<>()).add(acc);
                    vis[accountId] = true;
                }
            }
        }
        return nameToMails.keySet().stream().map(key -> {
                    List<String> acc = nameToMails.get(key);
                    Collections.sort(acc);
                    acc.add(0, idToName.get(key));
                    return acc;
                })
                .collect(Collectors.toList());
    }
    private int initialize(List<List<String>> accounts, Map<String, Integer> mailToId){
        int i, id = 0;

        for(List<String> account:accounts){
            String name = account.get(0);
            for(i=1; i<account.size(); i++){
                String acc = account.get(i);
                mailToId.put(acc, mailToId.getOrDefault(acc, id++));
            }
        }
        return id;
    }
}
