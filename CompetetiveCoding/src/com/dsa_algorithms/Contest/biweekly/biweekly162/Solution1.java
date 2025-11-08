package com.dsa_algorithms.Contest.biweekly.biweekly162;
import java.util.*;
public class Solution1 {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        List<List<Integer>> arr = new ArrayList<>();

        for(int i=0; i<landStartTime.length; i++){
            arr.add(List.of(landStartTime[i], landDuration[i]));
        }
        Collections.sort(arr, (a,b) -> Integer.compare(a.get(0)+a.get(1), b.get(0)+b.get(1)));
        int lt = arr.get(0).get(0), le = lt+arr.get(0).get(1);
        arr = new ArrayList<>();
        for(int i=0; i<waterStartTime.length; i++){
            arr.add(List.of(waterStartTime[i], waterDuration[i]));
        }
        Collections.sort(arr, (a,b) -> Integer.compare(a.get(0)+a.get(1), b.get(0)+b.get(1)));
        int wt = arr.get(0).get(0), we = wt+arr.get(0).get(1);


        if (lt > we){
            return le;
        }
        if (le < wt){
            return we;
        }
        if (le >= wt){
            return le + we-wt;
        }
        return we+le-lt;

    }
}
