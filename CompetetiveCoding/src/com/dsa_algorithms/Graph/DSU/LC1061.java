package com.dsa_algorithms.Graph.DSU;

public class LC1061 {
    static class DSU{
        int[] parent, size;
        public DSU(){
            parent = new int[26];
            size = new int[26];

            for(int i=0; i<26; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int getParent(int node){
            if (node == parent[node]){
                return node;
            }
            return parent[node] = getParent(parent[node]);
        }
        public void union(int a, int b){
            int pA = getParent(a), pB = getParent(b);
            if (pA == pB){
                return;
            }
            int sA = size[pA], sB = size[pB];
            if (sA > sB){
                parent[pB] = pA;
                size[pA] += sB;
            }
            else{
                parent[pA] = pB;
                size[pB] += sA;
            }
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int i, j;
        DSU dsu = new DSU();
        StringBuilder sb = new StringBuilder();

        for(i=0; i<s1.length(); i++){
            dsu.union(s1.charAt(i)-'a', s2.charAt(i)-'a');
        }

        for(i=0; i<baseStr.length(); i++){
            int base = baseStr.charAt(i) - 'a';
            int parent = dsu.getParent(base);
            for(j=0; j<26; j++){
                if (parent == dsu.getParent(j)){
                    sb.append((char)(j + 'a'));
                    break;
                }
            }
        }
        return sb.toString();
    }
}
