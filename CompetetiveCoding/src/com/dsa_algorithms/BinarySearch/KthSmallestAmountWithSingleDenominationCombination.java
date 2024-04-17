package com.dsa_algorithms.BinarySearch;

public class KthSmallestAmountWithSingleDenominationCombination {
    public long findKthSmallest(int[] coins, int k) {
        int i, j, n = coins.length;
        long lo = 1, mid, hi = (long)1e18, ans = 1;
        while(lo <= hi){
            mid = lo+(hi-lo)/2;
            long rank = countSmaller(mid, coins);
            if (rank >= k){
                hi = mid-1;
                if (rank == k)
                    ans = mid;
            }
            else
                lo = mid+1;
        }
        return ans;
    }
    public long gcd(long a, long b){
        return b == 0 ? a : gcd(b, a%b);
    }
    public long countSmaller(long num, int[] coins){
        int n = coins.length;
        long rank = 0;
        for(int mask = 1; mask < (1<<n); mask++){
            long cnt = 0, lcm = 1;
            for(int i = 0; i<n; i++){
                if ((mask&(1<<i)) > 0){
                    cnt++;
                    lcm = (lcm*coins[i])/gcd(lcm, (long)coins[i]);
                }
            }
            if (cnt % 2 == 0)
                rank -= num/lcm;
            else
                rank += num/lcm;
        }
        return rank;
    }
}
