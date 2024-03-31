package com.dsa_algorithms.Greedy;

public class WaterBottlesII {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = 0, emptyBottles = 0;

        while(numBottles+emptyBottles >= numExchange){
            if (emptyBottles >= numExchange){
                emptyBottles -= numExchange;
                numBottles++;
                numExchange++;
            }
            else{
                ans += numBottles;
                emptyBottles += numBottles;
                numBottles = 0;

            }
        }
        return ans+numBottles;
    }
}
