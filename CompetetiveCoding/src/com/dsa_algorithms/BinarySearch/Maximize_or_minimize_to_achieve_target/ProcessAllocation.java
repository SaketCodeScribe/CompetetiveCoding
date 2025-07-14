package com.dsa_algorithms.BinarySearch.Maximize_or_minimize_to_achieve_target;

import java.util.Arrays;

public class ProcessAllocation {
    private int getMinimumTime(int[] processSize, int[] capacity){
        int time = 0, i=0, j=0, m = processSize.length, n = capacity.length;
        Arrays.sort(processSize);
        Arrays.sort(capacity);

        while(i < m){
            if (j == n){
                j = 0;
                time += 2;
            }
            else if (processSize[i] <= capacity[j]){
                i++;
            }
            else{
                j++;
            }
        }
        return time;
    }
}
