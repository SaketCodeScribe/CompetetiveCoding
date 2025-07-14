package com.dsa_algorithms.practice;

import java.util.Scanner;

public class SlidingWindowSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Reading n and k
        int n = sc.nextInt();
        int k = sc.nextInt();

        // Reading x, a, b, c
        long x = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        long[] sequence = new long[n];
        sequence[0] = x;

        // Generate the sequence
        for (int i = 1; i < n; i++) {
            sequence[i] = (a * sequence[i - 1] + b) % c;
        }
        System.out.println(getSumWindow(sequence, n, k));
    }

    private static long getSumWindow(long[] sequence, int n, int k) {
        int i, left = 0;
        long sum = 0, ans = 0;

        for (i = 0; i < n; i++) {
            if (i < k) {
                sum += sequence[i];
            } else {
                ans ^= sum;
                sum += sequence[i] - sequence[left++];
            }
        }
        return ans ^ sum;
    }
}