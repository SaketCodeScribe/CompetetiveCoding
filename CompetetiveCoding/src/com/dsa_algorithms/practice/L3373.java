package com.dsa_algorithms.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class L3373 {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int m = edges1.length, n = edges2.length;
        List<List<Integer>> tree1 = new ArrayList<>();
        List<List<Integer>> tree2 = new ArrayList<>();

        for(int i=0; i<m; i++){
            tree1.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            tree2.add(new ArrayList<>());
        }
        for(int[] edge:edges1){
            tree1.get(edge[0]).add(edge[1]);
            tree1.get(edge[1]).add(edge[2]);
        }
        for(int[] edge:edges1){
            tree2.get(edge[0]).add(edge[1]);
            tree2.get(edge[1]).add(edge[2]);
        }
        int[] color1 = new int[m+1];
        int[] color2 = new int[n+1];
        Arrays.fill(color1, -1);
        Arrays.fill(color2, -1);
        dfs(tree1, color1, 0, 0);
        dfs(tree2, color2, 0, 0);
        int max = 0;
        for(int i=0; i<=n; i++){
            max = Math.max(max, color2[i]);
        }
        int odd = 0, even = 0;
        for(int i=0; i<=m; i++){
            if (color1[i] == 0){
                odd++;
            }
            else{
                even++;
            }
        }
        int[] ans = new int[m+1];
        for(int i=0; i<=m; i++){
            ans[i] = max+(color1[i] == 0 ? odd : even);
        }
        return ans;
    }
    private void dfs(List<List<Integer>> tree, int[] colors, int node, int color){
        colors[node] = color;

        for(int child:tree.get(node)){
            if (colors[child] == -1){
                dfs(tree, colors, child, (color+1)%2);
            }
        }
    }
}
