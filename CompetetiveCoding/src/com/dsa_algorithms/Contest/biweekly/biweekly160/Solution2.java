package com.dsa_algorithms.Contest.biweekly.biweekly160;

import java.util.*;
public class Solution2 {
    static class Node{
        int i, j, time;
        long cost;
        public Node(int x, int y, int t, long c){
            i = x;
            j = y;
            time = t;
            cost = c;
        }
    }

    public long minCost(int m, int n, int[][] waitCost) {
        int i, j;
        long ans = -1;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Long.compare(a.cost, b.cost));
        long[][] cost = new long[m][n];

        for(i=0; i<m; i++){
            for(j=0; j<n; j++){
                cost[i][j] = Long.MAX_VALUE;
            }
        }
        cost[0][0] = 1;
        pq.offer(new Node(0,0,1,1));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            i = node.i;
            j = node.j;
            int time = node.time;
            long ct = node.cost;
            if (ct > cost[i][j]){
                continue;
            }
            if (i == m-1 && j == n-1){
                ans = ct;
                break;
            }
            if ((time&1) == 1){
                int x, y;
                x = i;
                y = j+1;
                if (y < n && cost[x][y] > ct + (x+1L)*(y+1L)){
                    cost[x][y] = ct + (x+1L)*(y+1L);
                    pq.offer(new Node(x, y, time+1, cost[x][y]));
                }
                x = i+1;
                y = j;
                if (x < m && cost[x][y] > ct + (x+1L)*(y+1L)){
                    cost[x][y] = ct + (x+1L)*(y+1L);
                    pq.offer(new Node(x, y, time+1, cost[x][y]));
                }
            }
            else{
                cost[i][j] += (long)waitCost[i][j];
                pq.offer(new Node(i, j, time+1, cost[i][j]));
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
