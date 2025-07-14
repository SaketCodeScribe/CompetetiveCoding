package com.dsa_algorithms.Contest.biweekly.biweekly157;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution4 {

    private final int MOD = 1_000_000_007;
    public static void main(String[] args) {

    }
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int i, n = edges.length+1;
        List<List<Integer>> adj = new ArrayList<>();
        int[] ans = new int[queries.length];
        int[] level = new int[n];
        for(i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            adj.get(e[0]-1).add(e[1]-1);
        }
        int depth = findDepth(adj, level, 0);
        int[][] par = new int[22][n];
        dfs(0,-1, par, adj);
        int[][] dp = new int[depth][2];
        dp[1][0] = dp[1][1] = 1;
        for(i=2; i<depth; i++){
            dp[i][0] = (dp[i-1][0]+dp[i-1][1])%MOD;
            dp[i][1] = (dp[i-1][0]+dp[i-1][1])%MOD;
        }

        for(int[] q:queries){
            int x = q[0]-1, y = q[1]-1;
            int lca = findLCA(x, y, level, par);
            int diff1 = Math.abs(level[lca]-level[x]), diff2 = Math.abs(level[lca]-level[y]);
            if (lca == x || lca == y){
                ans[i++] = (diff1 > 0 ? dp[diff1][1] : dp[diff2][1])%MOD;
            }
            else{

                ans[i++] = (int)((((long)dp[diff1][1]*(long)dp[diff2][0])%MOD + ((long)dp[diff1][0]*(long)dp[diff2][1])%MOD)%MOD);
            }
        }
        return ans;
    }
    private int findDepth(List<List<Integer>> adj, int[] level, int root){
        int depth = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            while(size-- > 0){
                int node = queue.poll();
                level[node] = depth;
                for(int child:adj.get(node)){
                    queue.offer(child);
                }
            }
        }
        return depth;
    }
    private void dfs(int node, int parent, int[][] par, List<List<Integer>> adj){
        par[0][node] = parent;
        for (int j = 1; j < 22; j++) {
            if (par[j - 1][node] != -1) {
                par[j][node] = par[j - 1][par[j - 1][node]];
            } else {
                par[j][node] = -1;
            }
        }
        for (int child : adj.get(node)) {
            dfs(child, node, par, adj);
        }
    }
    private int findLCA(int x, int y, int[] level, int[][] par){
        if (level[x] > level[y]){
            return findLCA(y, x, level, par);
        }
        y = moveUp(y, level[y]-level[x], par);
        if (x == y){
            return x;
        }
        for(int j=21; j>0; j--){
            if (par[j][x] == par[j][y]){
                continue;
            }
            x = par[j][x];
            y = par[j][y];
        }
        return par[0][x];
    }
    private int moveUp(int x, int level, int[][] par){
        for(int j=21; j>=0; j--){
            if ((level & (1<<j)) != 0){
                x = par[j][x];
            }
        }
        return x;
    }
}
