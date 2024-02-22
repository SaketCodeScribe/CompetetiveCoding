package com.dsa_algorithms.DynamicProgramming;

/*
    k represents buckets to store the contiguous array (o index).
    i represents the ith elt.
    j represents the partition for kth bucket in which i will be put.
    we start with i=k to handle base scenarios i.e we should atleast have same no. of elts as bucket,
    otherwise we won't be able to create k non-empty buckets.


    There's also a O(n*d) solution using stack, not very clear about it. Let's explore it later.
 */

public class MinimumDifficultyofaJobSchedule {
    public static int subarrayMaximum(int[] arr, int K) {
        int i, j, k, n = arr.length;
        if (n < K)
            return -1;
        long[][] dp = new long[K][n];
        dp[0][0] = arr[0];
        for (i = 1; i < n; i++)
            dp[0][i] = Math.max(dp[0][i - 1], arr[i]);
        for (k = 1; k < K; k++) {
            for (i = k; i < n; i++) {
                int max = Integer.MIN_VALUE;
                dp[k][i] = Integer.MAX_VALUE;
                for (j = i; j >= k; j--) {
                    max = Math.max(max, arr[j]);
                    dp[k][i] = Math.min(dp[k][i], dp[k - 1][j - 1] + max);
                }
            }
        }
        return (int) dp[k - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(subarrayMaximum(new int[]{3, 4, 6, 7, 2}, 3));
        System.out.println(subarrayMaximum(new int[]{1, 2, 3}, 3));
        System.out.println(subarrayMaximum(new int[]{5, 6, 8, 1, 10}, 1));
        System.out.println(subarrayMaximum(new int[]{19, 76, 80, 145, 79, 109, 179, 41, 124, 90, 153, 27, 14, 157, 133, 119, 103, 28
        }, 9));
        System.out.println(subarrayMaximum(new int[]{66, 6, 84, 37, 20, 60, 33, 64, 25}, 8));
    }
}
