package com.dsa_algorithms.BinarySearch;

import java.util.Arrays;

public class MinNoDaysToMakeMBouquets {
    public static int minDays(int[] bloomDay, int m, int k) {
        int lo = Arrays.stream(bloomDay).min().getAsInt(), hi = Arrays.stream(bloomDay).max().getAsInt(), mid, ans = -1;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            int no = noOfBouquets(bloomDay, m, mid, k);
            if (no >= m) {
                hi = mid - 1;
                if (no == m)
                    ans = mid;
            } else
                lo = mid + 1;
        }
        return ans;
    }

    private static int noOfBouquets(int[] bloomDay, int m, int mid, int days) {
        int i, no = 0, cnt = 0;
        for (i = 0; i < bloomDay.length && no < m; i++) {
            if (bloomDay[i] <= mid)
                cnt++;
            else
                cnt = 0;
            if (cnt == days) {
                no++;
                cnt = 0;
            }
        }
        return no;
    }

    public static void main(String[] args) {
        System.out.println(minDays(new int[]{1000000000, 1000000000}, 1, 1));
    }
}
