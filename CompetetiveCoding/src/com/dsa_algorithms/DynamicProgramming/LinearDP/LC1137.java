package com.dsa_algorithms.DynamicProgramming.LinearDP;

public class LC1137 {
    public int tribonacci(int n) {
        if (n < 1){
            return 0;
        }
        int i, pprev = 0, prev = 1, curr = 1, next;

        for(i=3; i<=n; i++){
            next = pprev+prev+curr;
            pprev = prev;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
