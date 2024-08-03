package com.dsa_algorithms.BinarySearch.Maximize_or_minimize_to_achieve_target;

import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, mid, high = 0, ans = 0;
        for(int pile:piles)
            high = Math.max(pile, high);

        while(low <= high){
            mid = (low+high) >> 1;
            if (hoursToEat(piles, mid) <= h){
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return ans;
    }
    public long hoursToEat(int[] piles, int k){
        long hrs = 0;
        for(int pile:piles)
            hrs += (pile+k-1)/k;
        return hrs;
    }
}
