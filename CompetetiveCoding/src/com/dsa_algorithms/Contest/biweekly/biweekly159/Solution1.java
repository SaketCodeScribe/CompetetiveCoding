package com.dsa_algorithms.Contest.biweekly.biweekly159;

import java.util.*;

public class Solution1 {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        List<Integer> odd = new ArrayList<>(), even = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            (nums[i] % 2 == 0 ? even : odd).add(i);
        }

        int oddCount = odd.size(), evenCount = even.size();
        if ((n % 2 == 0 && oddCount != evenCount) || (n % 2 == 1 && Math.abs(oddCount - evenCount) != 1)) {
            return -1;
        }

        if (n % 2 == 1)
            return oddCount > evenCount ? minSwap(odd, even) : minSwap(even, odd);
        return Math.min(minSwap(even, odd), minSwap(odd, even));
    }

    private int minSwap(List<Integer> first, List<Integer> second) {
        int i = 0, j = 0, k = 0, ans = 0;
        boolean useFirst = true;
        int n = first.size() + second.size();

        while (i < n && j < first.size() && k < second.size()) {
            if (useFirst) {
                if (first.get(j) > second.get(k)) {
                    ans += binarySearch(second, k, first.get(j)) - k + 1;
                }
                j++;
            } else {
                if (second.get(k) > first.get(j)) {
                    ans += binarySearch(first, j, second.get(k)) - j + 1;
                }
                k++;
            }
            useFirst = !useFirst;
            i++;
        }
        return ans;
    }

    private int binarySearch(List<Integer> list, int low, int target) {
        int high = list.size() - 1, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < target) {
                ans = mid;
                low = mid + 1;
            } else high = mid - 1;
        }
        return ans;
    }
}
