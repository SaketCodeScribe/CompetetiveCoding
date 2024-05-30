package com.dsa_algorithms.Greedy;

public class MinimumJump {
    public static int minimumJumps(int[] arr, int n) {
        // Write your code here
        if (arr[0] == 0 && n > 1)
            return -1;
        if (n == 1)
            return 0;
        int jump = 1, i = arr[0], max = arr[0], j = 1;

        while(i < n-1){
            max = Math.max(max, j+arr[j]);
            if (j == i && max > i){
                i = max;
                jump++;
            }
            if (j == i && max == i)
                return -1;
            j++;
        }
        return jump;
    }
}
