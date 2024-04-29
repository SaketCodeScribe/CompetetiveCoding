package com.dsa_algorithms.Maths;

public class SelfCrossing {
    public boolean isSelfCrossing(int[] dist) {
        int i, n = dist.length;
        for(i=0; i<n; i++){
            if (i >= 3 && dist[i-1] <= dist[i-3] && dist[i] >= dist[i-2])
                return true;
            if (i >= 4 && dist[i-1] == dist[i-3] && dist[i]+dist[i-4] >= dist[i-2])
                return true;
            if (i >= 5 && dist[i-3] > dist[i-1] && dist[i-3]-dist[i-5] <= dist[i-1] && dist[i-2] > dist[i-4] && dist[i-2]-dist[i] <= dist[i-4])
                return true;
        }
        return false;
    }
}
