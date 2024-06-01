package com.dsa_algorithms.Greedy;

public class JumpGame {
    public static int minJumps(int []arr, int n) {
        // Write your code here.
        if (n == 1)
            return 0;
        int i, max, nextMax, jump = 1;
        i=0;
        max = nextMax = arr[0];

        while(i < n && max < n-1){
            nextMax = Math.max(nextMax, i+arr[i]);
            if (i == max){
                if (nextMax > max){
                    max = nextMax;
                    jump++;
                }
                else
                    return -1;
            }
            i++;
        }
        return jump;
    }
}
