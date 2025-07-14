package com.dsa_algorithms.Contest.weekly.weekly451;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(minCuttingCost(6,5,5));

    }
    public static long minCuttingCost(int n, int m, int k) {
        if (n < m){
            return minCuttingCost(m, n, k);
        }
        long cost = 0;
        if (n > k){
            cost +=(long)k*(long)(n-k);
        }
        return cost;
    }
}
