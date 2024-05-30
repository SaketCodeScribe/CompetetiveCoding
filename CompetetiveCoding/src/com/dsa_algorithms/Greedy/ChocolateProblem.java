package com.dsa_algorithms.Greedy;

import java.util.*;

public class ChocolateProblem {
    static int findMinDiff(int n, int m, ArrayList<Integer> chocolates) {
        int i = m-1, ans = Integer.MAX_VALUE;
        Collections.sort(chocolates);
        while(i < n)
            ans = Math.min(ans, chocolates.get(i)-chocolates.get(++i-m));
        return ans;
    }
}
