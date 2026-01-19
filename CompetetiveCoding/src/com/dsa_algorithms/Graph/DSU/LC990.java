package com.dsa_algorithms.Graph.DSU;

import java.util.Arrays;

public class LC990 {
    static class DSU{
        private int[] parent, size;
        public DSU(){
            parent = new int[26];
            size = new int[26];

            for(int i=0; i<26; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public void union(int parA, int parB){
            if (parA == parB){
                return;
            }
            int sizeA = size[parA], sizeB = size[parB];
            if (sizeA > sizeB){
                parent[parB] = parA;
                size[parA] += sizeB;
            }
            else{
                parent[parA] = parB;
                size[parB] += sizeA;
            }
        }
        public int getParent(int node){
            if (node == parent[node]){
                return node;
            }
            return parent[node] = getParent(parent[node]);
        }
    }
    public boolean equationsPossible(String[] equations) {
        int parA, parB;
        DSU dsu = new DSU();

        Arrays.sort(equations, (a, b) -> -1*Character.compare(a.charAt(1), b.charAt(1)));

        for(String equation:equations){
            int a = equation.charAt(0) - 'a', b = equation.charAt(3) - 'a';
            char op = equation.charAt(1);
            parA = dsu.getParent(a);
            parB = dsu.getParent(b);
            if (op == '!' && parA == parB){
                return false;
            }

            if (op == '='){
                dsu.union(parA, parB);
            }
        }
        return true;
    }
}
