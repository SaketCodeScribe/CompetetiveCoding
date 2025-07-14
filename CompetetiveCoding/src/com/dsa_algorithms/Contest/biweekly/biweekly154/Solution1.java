package com.dsa_algorithms.Contest.biweekly.biweekly154;

import java.util.Arrays;

public class Solution1 {

    public int minOperations(int[] nums, int k) {
        return Arrays.stream(nums).sum()%k;
    }
}
