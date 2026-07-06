package com.dsa_algorithms.Sorting;

import java.util.Arrays;

public class LC1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->
                a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        int kept = 1;
        int left = 0;
        for (int right = 1; right < intervals.length; right++) {
            if (intervals[right][1] > intervals[left][1]) {
                left = right;
                kept++;
            }
        }
        return kept;
    }
}
