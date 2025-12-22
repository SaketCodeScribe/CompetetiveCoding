package com.dsa_algorithms.Greedy.IntervalScheduling_ActivitySelection;

import java.util.Arrays;

public class LC435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int cnt = 0, n = intervals.length, i, lastEnding = -49_999;

        Arrays.sort(intervals, (a, b) -> a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0]));

        for(i=0; i<n; i++){
            if (intervals[i][0] < lastEnding){
                cnt++;
            }
            else{
                lastEnding = intervals[i][1];
            }
        }
        return cnt;
    }
}
