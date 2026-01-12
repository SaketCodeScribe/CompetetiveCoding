package com.dsa_algorithms.Graph.GraphTheory;

public class LC997 {
    public int findJudge(int n, int[][] trust) {
        int[] people = new int[n+1];

        for(int[] t:trust){
            people[t[1]]++;
            people[t[0]]--;
        }
        for(int i=1; i<=n; i++){
            if (people[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}
