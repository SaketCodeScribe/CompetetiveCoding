package com.dsa_algorithms.BinarySearch;

import java.math.BigDecimal;

public class NthRootOfM {
    public static int NthRoot(int n, int m) {
        if (m == 1 || n == 1)
            return m;
        int mid, lo = 1, hi = m, ans = -1;
        long pow;

        while(lo <= hi){
            mid = lo+(hi-lo)/2;
            pow = power(n, mid, m);
            System.out.println(lo+" "+mid+" "+hi+": "+pow);
            if (pow >= m){
                hi = mid-1;
                if (pow == m)
                    ans = mid;
            }
            else
                lo = mid+1;
        }
        return ans;
    }
    static long power(long n, long x, long m){
        if (x > m || n == 1)
            return x;
        if (n == 0)
            return 1;
        long pow = power(n/2, x*x, m);
        if (pow > m || n%2 == 0)
            return pow;
        return pow *= x;
    }

    public static void main(String[] args) {
        System.out.println(NthRoot(6, 64));
    }

}
