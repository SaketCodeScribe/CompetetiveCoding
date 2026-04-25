package com.dsa_algorithms.BinarySearch;

public class LC3733 {
    public long minimumTime(int[] d, int[] r) {
        assert r[0] != 1;
        assert r[1] != 1;
        return timeTaken(d[0]+d[1], d[0], d[1], r[0], r[1], lcm(r[0], r[1]));
    }
    private long timeTaken(int deliveries, int d1, int d2, int r1, int r2, int gcd){
        long low = 1, high = deliveries*10L, mid, ans = low;

        while(low <= high){
            mid = low + (high-low)/2;
            long noOfDeliveries = getDeliveries(mid, d1, d2, r1, r2, gcd);
            if (noOfDeliveries >= deliveries){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    private int lcm(int a, int b){
        return (a*b) / gcd(a, b);
    }
    private int gcd(int a, int b){
        if (b == 0) return a;
        return gcd(b, a%b);
    }
    private long getDeliveries(long time, long d1, long d2, long r1, long r2, long gcd){
        long freeSlots = time - time/r1 - time/r2 + time/gcd;

        return freeSlots + Math.min(time/r1 - time / gcd, d2) + Math.min(time/r2 - time / gcd, d1);
    }
}
