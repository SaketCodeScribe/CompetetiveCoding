package com.dsa_algorithms.PeakAndTrough;

public class BestTimeToBuyAndSellAllStocks {
    public static int maxProfit(int[] prices) {
        // Write your code here.
        int i, n = prices.length, profit = 0;

        for(i=1; i<n; i++){
            if (prices[i] >= prices[i-1])
                profit += prices[i]-prices[i-1];
        }
        return profit;
    }
}
