package com.dsa_algorithms.DynamicProgramming.BuySellStock;

public class LC309 {
    public int maxProfit(int[] prices) {
        int i, n = prices.length, psell = 0, pbuy = Integer.MIN_VALUE, ppsell = 0, buy, sell;

        for(i=0; i<n; i++){
            buy = Math.max(pbuy, ppsell - prices[i]);
            sell = Math.max(psell, buy + prices[i]);
            pbuy = buy;
            ppsell = psell;
            psell = sell;
        }
        return psell;
    }
}
