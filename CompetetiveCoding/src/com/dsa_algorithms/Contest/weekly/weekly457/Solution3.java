package com.dsa_algorithms.Contest.weekly.weekly457;

import java.util.*;

public class Solution3 {
    int[] par;
    int[] size;

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int i;
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        par = new int[c+1];
        size = new int[c+1];

        for(i=1; i<=c; i++){
            par[i] = i;
            size[i] = 1;
        }
        for (int[] conn:connections){
            union(conn[0], conn[1]);
        }
        for(i=1; i<=c; i++){
            int parent = findPar(i);
            map.computeIfAbsent(parent, x -> new TreeSet<>()).add(i);
        }
        List<Integer> ans = new ArrayList<>();
        for(int[] query:queries){
            int type = query[0], node = query[1], parent = findPar(node);
            TreeSet<Integer> treeSet = map.get(parent);
            if (type == 2){
                treeSet.remove(node);
            }
            else{
                if (treeSet.contains(node)){
                    ans.add(node);
                }
                else if (!treeSet.isEmpty()){
                    ans.add(treeSet.first());
                }
                else{
                    ans.add(-1);
                }
            }
        }
        return ans.stream().mapToInt(val -> val).toArray();
    }
    public int findPar(int a){
        if (a == par[a])
            return a;
        return par[a] = findPar(par[a]);
    }
    public void union(int a, int b){
        int parA = findPar(a), parB = findPar(b), sizeA, sizeB;
        if (parA == parB){
            return;
        }
        sizeA = size[parA];
        sizeB = size[parB];
        if (sizeA > sizeB){
            par[parB] = parA;
            size[parA] += size[parB];
        }
        else{
            par[parA] = parB;
            size[parB] += size[parA];
        }
    }
    public static void main(String[] args) {
        Solution3 obj = new Solution3();
    }
}
