package com.dsa_algorithms.Greedy.ResourceAllocation_Matching;

import java.util.Arrays;
import java.util.TreeMap;

public class LC881 {
    public int numRescueBoats(int[] people, int limit) {
        int i = 0, j = people.length-1, boats = 0;
        Arrays.sort(people);

        while(i <= j){
            if (people[i]+people[j] <= limit){
                i++;
                j--;
            }
            else{
                j--;
            }
            boats++;
        }
        return boats;
    }
}
