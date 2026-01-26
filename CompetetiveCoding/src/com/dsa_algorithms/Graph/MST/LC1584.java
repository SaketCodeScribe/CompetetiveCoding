package com.dsa_algorithms.Graph.MST;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC1584 {
    private static final long OFFSET = 10_00_000;

    static class DSU{
        Map<Long, Long> parent;
        Map<Long, Integer> size;
        public DSU(int[][] points){
            parent = new HashMap<>();
            size = new HashMap<>();

            for(int[] point:points){
                long index = getPoint(point[0], point[1]);
                parent.put(index, index);
                size.put(index, 1);
            }
        }
        public long getParent(long node){
            long par = parent.get(node);
            if (par == node){
                return par;
            }
            par = getParent(par);
            parent.put(node, par);
            return par;
        }
        public boolean union(Long a, Long b){
            long parA = getParent(a), parB = getParent(b);
            if (parA == parB){
                return false;
            }
            int sizeA = size.get(parA), sizeB = size.get(parB);
            if (sizeA > sizeB){
                parent.put(parB, parA);
                size.put(parA, sizeA+sizeB);
            }
            else{
                parent.put(parA, parB);
                size.put(parB, sizeA+sizeB);
            }
            return true;
        }
    }

    private static long getPoint(int x, int y){
        return (x+OFFSET)*(2*OFFSET+1) + (y+OFFSET);
    }

    private int getManHattanDistance(int x1, int y1, int x2, int y2){
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }

    public int minCostConnectPoints(int[][] points) {
        int i = 0, j, k = 0, n = points.length, minCost = 0;
        DSU dsu = new DSU(points);
        int[][] edges = new int[n*(n-1)/2][];

        for(i=0; i<n; i++){
            for(j=i+1; j<n; j++){
                edges[k++] = new int[]{points[i][0], points[i][1], points[j][0], points[j][1], getManHattanDistance(points[i][0], points[i][1], points[j][0], points[j][1])};
            }
        }
        Arrays.sort(edges, (a, b) -> Integer.compare(a[4], b[4]));
        n = edges.length;

        for(i=0; i<n; i++){
            if (dsu.union(getPoint(edges[i][0], edges[i][1]), getPoint(edges[i][2], edges[i][3]))){
                minCost += edges[i][4];
            }
        }
        return minCost;
    }
}
