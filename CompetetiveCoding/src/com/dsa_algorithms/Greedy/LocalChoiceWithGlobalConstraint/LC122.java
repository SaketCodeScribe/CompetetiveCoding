package com.dsa_algorithms.Greedy.LocalChoiceWithGlobalConstraint;

public class LC122 {
    public int maxProfit(int[] prices) {
        int i, n = prices.length, profit = 0;;

        for(i=1; i<n; i++){
            if (prices[i] >= prices[i-1])
                profit += prices[i]-prices[i-1];
        }
        return profit;
    }
}
