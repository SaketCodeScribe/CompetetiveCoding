package com.dsa_algorithms.DynamicProgramming.LinearDP;

public class LC70 {
    public int climbStairs(int n) {
        int i, curr = 1, prev = 0, next;

        for(i=1; i<=n; i++){
            next = curr+prev;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
