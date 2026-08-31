package com.dsa_algorithms.Greedy;

import java.util.HashMap;
import java.util.Map;

public class LC1386 {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int ans;
        int left = 0b11110000;
        int mid = 0b11000011;
        int right = 0b00001111;
        Map<Integer, Integer> table = new HashMap<>();

        for(int[] seat:reservedSeats) {
            if (seat[1] > 1 && seat[1] < 10) table.put(seat[0], table.getOrDefault(seat[0], 0) | (1 << seat[1]-2));
        }
        ans = 2*(n-table.size());
        for(Map.Entry<Integer, Integer> entry:table.entrySet()) {
            int bitMask = entry.getValue();
            if ((bitMask | left) == left ||
                    (bitMask | mid) == mid ||
                    (bitMask | right) == right) ans++;

        }
        return ans;
    }
}
