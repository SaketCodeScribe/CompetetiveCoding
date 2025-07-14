package com.dsa_algorithms.Contest.weekly.weekly454;

import java.util.*;

public class Solution4 {
    public int[] findMedian(int n, int[][] edges, int[][] queries) {
        int i;
        List<List<List<Integer>>> adj = new ArrayList<>();
        int[] ans = new int[queries.length];
        int[] level = new int[n];
        for(i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            adj.get(e[0]).add(List.of(e[1], e[2]));
        }

        int[][] par = new int[22][n];
        findDepth(adj, level, 0);
        Map<String, Integer> map = new HashMap<>();
        dfs(0,-1, par, adj, map, 0, 0);
        i = 0;
        for(int[] query:queries){
            int x = query[0], y = query[1];
            int lca = findLCA(x, y, level, par);
            int sumToLCA = map.get(level[lca]+","+lca);
            int sumToX = map.get(level[x]+","+x);
            int sumToY = map.get(level[y]+","+y);
            int leftSum = sumToX - sumToLCA;
            int rightSum = sumToY - sumToLCA;
            int medianSum = (leftSum+rightSum)/2;
            if (leftSum > medianSum){
                ans[i++] = binarySearch(par, level, map, sumToX, x, medianSum);
            }
            else{
                ans[i++] = binarySearch(par, level, map, sumToY, y, medianSum - leftSum);
            }
        }
        return ans;
    }

    private int binarySearch(int[][] par, int[] level, Map<String, Integer> map, int nodeSum, int x, int medianSum) {
        int low = 0, high = 21, ans = -1;

        while(low <= high){
            int mid = low + (high-low)/2;
            int node = par[mid][x];
            int sumToNode = map.get(level[node]+","+node);
            int calSum = nodeSum - sumToNode;
             if (calSum >= medianSum){
                 ans = node;
                 high = mid-1;
             }
             else{
                 low = mid+1;
             }
        }
        return ans;
    }

    private int findDepth(List<List<List<Integer>>> adj, int[] level, int root){
        int depth = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            while(size-- > 0){
                int node = queue.poll();
                level[node] = depth-1;
                for(List<Integer> neighbor:adj.get(node)){
                    int child = neighbor.get(0);
                    queue.offer(child);
                }
            }
        }
        return depth;
    }
    private void dfs(int node, int parent, int[][] par, List<List<List<Integer>>> adj, Map<String, Integer> map, int sum, int level){
        par[0][node] = parent;
        map.put(level+","+node, sum);

        for(int jump=21; jump>=0; jump--){
            if (par[jump][node] != -1){
                par[jump][node] = par[jump-1][par[jump-1][node]];
            }
            else{
                par[jump][node] = -1;
            }
        }
        for(List<Integer> neighbor: adj.get(node)){
            int child = neighbor.get(0), wt = neighbor.get(1);
            dfs(child, node, par, adj, map, sum+wt, level+1);
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
        for (int jump = 21; jump >=0 ; jump--){
            if (par[jump][x] != -1 && par[jump][x] != par[jump][y]){
                x = par[jump][x];
                y = par[jump][y];
            }
        }
        return par[0][x];
    }
    private int moveUp(int x, int level, int[][] par){
        for(int jump=21; jump>=0; jump--){
            if ((level & (1<<jump)) != 0){
                x = par[jump][x];
            }
        }
        return x;
    }
}
