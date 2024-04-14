package com.dsa_algorithms.SegmentTree;

import java.util.*;

public class DistributeElementsIntoTwoArraysII {

    Map<Integer, Integer> valToI;
    int[] tree1, tree2;

    public int[] resultArray(int[] nums) {
        int n = nums.length;
        valToI = new HashMap<>();
        functValToI(Arrays.copyOf(nums, n), n);
        tree1 = new int[4 * n];
        tree2 = new int[4 * n];
        int[] ans = new int[n];
        int j = 0, k = 1;

        // Process the first element
        ans[j++] = nums[0];
        update(0, valToI.get(nums[0]), 0, n - 1, tree1);
        nums[0] = -1;
        update(0, valToI.get(nums[1]), 0, n - 1, tree2);

        // Process the remaining elements
        for (int i = 2; i < n; i++) {
            int ind = valToI.get(nums[i]);
            int a = rangeQuery(0, ind + 1, n - 1, 0, n - 1, tree1);
            int b = rangeQuery(0, ind + 1, n - 1, 0, n - 1, tree2);

            // Update trees and ans array based on conditions
            if (a > b || (a == b && j <= k)) {
                update(0, ind, 0, n - 1, tree1);
                ans[j++] = nums[i];
                nums[i] = -1;
            } else {
                update(0, ind, 0, n - 1, tree2);
                k++;
            }
        }

        // Append remaining elements to ans array
        for (int i = 0; i < n; i++) {
            if (nums[i] > -1)
                ans[j++] = nums[i];
        }

        return ans;
    }

    // Function to create a mapping from value to index
    public void functValToI(int[] nums, int n) {
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (!valToI.containsKey(nums[i])) {
                valToI.put(nums[i], i);
            }
        }
    }

    // Function to update the segment tree
    public void update(int i, int ind, int l, int r, int[] tree) {
        if (l == r) {
            tree[i]++;
            return;
        }

        int mid = l + (r - l) / 2;
        if (mid >= ind)
            update(2 * i + 1, ind, l, mid, tree);
        else
            update(2 * i + 2, ind, mid + 1, r, tree);

        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }

    // Function to perform range query on the segment tree
    public int rangeQuery(int i, int x, int y, int l, int r, int[] tree) {
        if (l >= x && r <= y)
            return tree[i];

        if (Math.min(r, y) < Math.max(l, x))
            return 0;

        int mid = l + (r - l) / 2;
        return rangeQuery(2 * i + 1, x, y, l, mid, tree) + rangeQuery(2 * i + 2, x, y, mid + 1, r, tree);
    }
}
