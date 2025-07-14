package com.dsa_algorithms.practice;

import java.io.*;

public class SlidingWindowOr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        // Reading inputs
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        String[] abc = br.readLine().split(" ");
        long x = Long.parseLong(abc[0]);
        long a = Long.parseLong(abc[1]);
        long b = Long.parseLong(abc[2]);
        long c = Long.parseLong(abc[3]);

        // Generate the sequence
        long[] seq = new long[n];
        seq[0] = x;
        for (int i = 1; i < n; i++) {
            seq[i] = (a * seq[i - 1] + b) % c;
        }

        long result = 0;

        // Block decomposition approach
        int blocks = (n + k - 1) / k;
        long[] prefix = new long[k];
        long[] suffix = new long[k];

        for (int blk = 0; blk < blocks; blk++) {
            int start = blk * k;
            int end = Math.min(n - 1, start + k - 1);

            // Build suffix ORs for current block
            suffix[end - start] = seq[end];
            for (int i = end - 1; i >= start; i--) {
                suffix[i - start] = seq[i] | suffix[i - start + 1];
            }

            // Build prefix ORs for next block if needed
            if (blk + 1 < blocks) {
                int nextStart = (blk + 1) * k;
                int nextEnd = Math.min(n - 1, nextStart + k - 1);
                prefix[0] = seq[nextStart];
                for (int i = nextStart + 1; i <= nextEnd; i++) {
                    prefix[i - nextStart] = seq[i] | prefix[i - nextStart - 1];
                }
            }

            // Process windows starting in current block
            for (int i = start; i <= end && i + k - 1 < n; i++) {
                int j = i + k - 1;
                long orValue = suffix[i - start];
                if (j / k == blk + 1) {
                    orValue |= prefix[j % k];
                }
                result ^= orValue;
            }
        }

        System.out.println(result);
    }
}
