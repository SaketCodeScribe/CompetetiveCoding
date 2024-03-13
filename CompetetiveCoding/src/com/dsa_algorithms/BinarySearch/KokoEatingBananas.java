package com.dsa_algorithms.BinarySearch;

import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int mid, lo = 1, hi = Arrays.stream(piles).max().getAsInt(), ans = -1;
        long hrs;
        while(lo < hi){
            mid = lo+(hi-lo)/2;
            hrs = findK(piles, mid);
            if (hrs <= h)
                hi = mid;
            else
                lo = mid+1;
        }
        return hi;
    }

    private long findK(int[] piles, int mid) {
        long hrs = 0;
        for(int pile:piles){
            hrs += pile/mid;
            if (pile%mid != 0)
                hrs++;
        }
        return hrs;
    }

    public static void main(String[] args) {
        KokoEatingBananas obj = new KokoEatingBananas();
        System.out.println(obj.minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000));
    }
}
