package com.dsa_algorithms.Greedy.cumulative_sum;

import java.util.*;
public class MinNoOfCoinsToBeAdded {
    public int minimumAddedCoins(int[] coins, int target) {
        int i, next, n = coins.length, sum = 0, ans = 0;
        i =0 ; next = 1;
        Arrays.sort(coins);

        while(next <= target){
            if (i < n && coins[i] <= next)
                sum += coins[i++];
            else if (sum < next){
                ans++;
                sum += next;
            }
            else
                next = sum;
            next++;
        }
        return ans;
    }
}
