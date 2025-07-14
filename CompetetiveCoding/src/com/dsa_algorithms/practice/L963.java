package com.dsa_algorithms.practice;

import java.util.*;

public class L963 {

    public double minAreaFreeRect(int[][] points) {
        int i, j, n = points.length;
        double area = Integer.MAX_VALUE;
        Map<String, List<int[]>> map = new HashMap<>();

        for(i=0; i<n; i++){
            for(j=i+1; j<n; j++){
                int midX = points[i][0]+points[j][0];
                int midY = points[i][1]+points[j][1];
                long distSquare = getDistSquare(points[i][0], points[i][1], points[j][0], points[j][1]);
                map.computeIfAbsent(midX+","+midY+","+distSquare, x -> new ArrayList<>())
                        .add(new int[]{points[i][0], points[i][1], points[j][0], points[j][1]});
            }
        }
        for(List<int[]> key: map.values()){
            int m = key.size();
            for(i=0; i<m; i++){
                int[] point1 = key.get(i);
                int x1 = point1[0], y1 = point1[1], x2 = point1[2], y2 = point1[3];
                for(j=i+1; j<m; j++){
                    int[] point2 = key.get(j);
                    int x3 = point2[0], y3 = point2[1], x4 = point2[2], y4 = point2[3];
                    long dist1 = getDistSquare(x1, y1, x3, y1);
                    long dist2 = getDistSquare(x2, y2, x4, y4);
                    area = Math.min(area, getArea(dist1, dist2));
                }
            }
        }
        return area < Integer.MAX_VALUE ? area : 0;
    }

    private static double getArea(long dist1, long dist2) {
        return Math.sqrt(dist1 * dist2);
    }

    private static long getDistSquare(long x1, long y1, long x2, long y2) {
        return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
    }
}
