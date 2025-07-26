package com.dsa_algorithms.practice;

import java.util.*;

public class L1411 {
    private final int MOD = 1_000_000_007;
    public int numOfWays(int n) {
        long pattern121 = 6, pattern123 = 6;

        for(int i=2; i<=n; i++){
            long temp = pattern121;
            pattern121 = (pattern121*3 + pattern123*2)%MOD;
            pattern123 = (pattern123*2 + temp*2)%MOD;
        }
        return (int)((pattern121+pattern123)%MOD);
    }
}
