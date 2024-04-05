package com.dsa_algorithms.Greedy;

import java.util.Arrays;

public class AppleRedistributionintoBoxes {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int i, sum = Arrays.stream(apple).sum(), m = capacity.length;
        Arrays.sort(capacity);
        for(i=m-1; i>=0 && sum > 0; i--)
            sum -= capacity[i];
        return m-i-1;
    }
}
