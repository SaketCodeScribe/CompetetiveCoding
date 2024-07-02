package com.dsa_algorithms.Sorting;

import java.util.*;
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int i, n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        ans.add(intervals[0]);
        for(i=1; i<n; i++){
            int[] curr = ans.get(ans.size()-1);
            if (isOverlap(curr, intervals[i]))
                curr[1] = Math.max(curr[1], intervals[i][1]);
            else
                ans.add(intervals[i]);
        }
        return ans.toArray(int[][]::new);
    }
    public boolean isOverlap(int[] a, int[] b){
        return !(Math.max(a[0],b[0]) > Math.min(a[1], b[1]));
    }
}
