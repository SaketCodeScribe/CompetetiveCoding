package com.dsa_algorithms.Greedy;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i, n = cost.length, ans = 0, fuel = 0, totFuel = 0;

        for(i=0; i<n; i++){
            totFuel += gas[i]-cost[i];
            fuel += gas[i]-cost[i];
            if (fuel < 0){
                fuel = 0; ans = i+1;
            }
        }
        return totFuel >= 0 ? ans : -1;
    }
}
