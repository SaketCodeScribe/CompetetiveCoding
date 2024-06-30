package com.dsa_algorithms.Maths;

import java.util.*;
public class MinMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        return sum-min*n;
    }
}
