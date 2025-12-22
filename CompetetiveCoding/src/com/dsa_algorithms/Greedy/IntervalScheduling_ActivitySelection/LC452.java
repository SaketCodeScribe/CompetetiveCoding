package com.dsa_algorithms.Greedy.IntervalScheduling_ActivitySelection;

import java.util.Arrays;

public class LC452 {
    public int findMinArrowShots(int[][] points) {
        int cnt = 1, prevIndex, n = points.length, i;

        Arrays.sort(points, (a, b) -> a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0]));
        prevIndex = points[0][1];

        for(i=1; i<n; i++){
            if (points[i][0] > prevIndex){
                cnt++;
                prevIndex = points[i][1];
            }
        }
        return cnt;
    }
}
