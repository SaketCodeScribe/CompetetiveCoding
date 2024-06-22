package com.dsa_algorithms.Maths;

public class TrailingZeroesInAFactorial {
    static int trailingZerosInFactorial(int n) {
        // Write your code here.
        int ans = 0, pow = 5;

        while(n/pow > 0){
            ans += n/pow;
            pow *= 5;

        }
        return ans;
    }
}
