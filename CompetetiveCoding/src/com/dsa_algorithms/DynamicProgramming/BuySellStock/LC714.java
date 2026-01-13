package com.dsa_algorithms.DynamicProgramming.BuySellStock;

public class LC714 {
    public int maxProfit(int[] prices, int fee) {
        int i, n = prices.length, psell = 0, pbuy = Integer.MIN_VALUE, buy, sell, price;

        for(i=0; i<n; i++){
            price = prices[i];
            buy = Math.max(pbuy, psell - price);
            sell = Math.max(psell, buy + price - fee);
            pbuy = buy;
            psell = sell;
        }
        return psell;
    }
}
