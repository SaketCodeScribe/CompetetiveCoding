package com.dsa_algorithms.Maths;

public class LC172 {
    public int trailingZeroes(int n) {
    int ans = 0;
    while(n > 0){
        ans += n/5;
        n /= 5;
    }
    return ans;
}
}
