package com.dsa_algorithms.practice;

import java.util.*;

public class L939 {
    private final int offset = 4_00_001;
    public int minAreaRect(int[][] points) {
        int i, j, n = points.length, ans = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        Arrays.sort(points, (a,b) -> {
            if (a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        for(i=0; i<n; i++){
            for(j=i; j>=0; j--){
                if (points[i][0] > points[j][0] && points[i][1] > points[j][1]){
                    int x1 = points[j][0], x2 = points[i][0];
                    int y1 = points[j][1], y2 = points[i][1];
                    int cord1 = (x1+1)*offset+y2, cord2 = (x2+1)*offset+y1;
                    if (set.contains(cord1) && set.contains(cord2)){
                        ans = Math.min(ans, (x2-x1)*(y2-y1));
                    }
                }
            }
            set.add((points[i][0]+1)*offset + points[i][1]);
        }
        return ans < Integer.MAX_VALUE ? ans : 0;
    }
}
