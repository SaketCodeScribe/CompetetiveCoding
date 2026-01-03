package com.dsa_algorithms.Greedy.LocalChoiceWithGlobalConstraint;

public class LC134 {
    // 1.
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length, i=0, j, fuel = 0, choice = -1;

        for(j=0; j<2*n && i<n; j++){
            fuel += gas[j%n] - cost[j%n];
            while(fuel < 0 && i <= j && i < n){
                fuel -= (gas[i] - cost[i]);
                i++;
            }
            if (fuel >= 0 && i == j-n){
                choice = i;
                break;
            }
        }
        return choice;
    }

    // 2.
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, i, fuel = 0, totFuel = 0, choice = 0;

        for(i=0; i<n; i++){
            totFuel += gas[i] - cost[i];
            fuel += gas[i] - cost[i];
            if (fuel < 0){
                fuel = 0;
                choice = i+1;
            }
        }
        return totFuel >= 0 ? choice : -1;
    }
}
