package com.dsa_algorithms.Graph.GraphTheory;

public class LC1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        int i, j, ans = 0;
        int[] cityRoad = new int[n];
        boolean[][] connected = new boolean[n][n];

        for(int[] road:roads){
            cityRoad[road[0]]++;
            cityRoad[road[1]]++;
            connected[road[0]][road[1]] = connected[road[1]][road[0]] = true;
        }
        for(i=0; i<n; i++){
            for(j=i+1; j<n; j++){
                ans = Math.max(ans, cityRoad[i] + cityRoad[j] + (connected[i][j] ? -1 : 0));
            }
        }
        return ans;
    }
}
