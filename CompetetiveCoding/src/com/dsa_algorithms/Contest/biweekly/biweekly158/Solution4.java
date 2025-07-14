package com.dsa_algorithms.Contest.biweekly.biweekly158;

import java.util.*;

public class Solution4 {

    // A long is used for the answer to prevent potential integer overflow during summation.
    private long ans;
    // The modulus constant for the final result.
    private static final int MOD = 1_000_000_007;

    /**
     * Calculates the good subtree sum for the entire tree.
     *
     * @param vals An array of integer values for each node.
     * @param par  An array representing the parent of each node, defining the tree structure.
     * @return The calculated sum modulo 10^9 + 7.
     */
    public int goodSubtreeSum(int[] vals, int[] par) {
        int n = vals.length;
        // The adjacency list to represent the tree structure.
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Build the adjacency list from the parent array. Node 0 is the root.
        for (int i = 1; i < n; i++) {
            adj[par[i]].add(i);
        }

        // Initialize the answer and start the DFS from the root (node 0).
        this.ans = 0;
        dfs(0, vals, adj);

        // The final answer must be a non-negative integer.
        // (ans % MOD + MOD) % MOD handles potential negative results from the % operator in Java.
        return (int) ((this.ans % MOD + MOD) % MOD);
    }

    /**
     * Performs a post-order traversal (DFS) to compute subtree sums.
     *
     * @param u    The current node being visited.
     * @param vals The array of node values.
     * @param adj  The adjacency list of the tree.
     * @return A map where keys are bitmasks of used digits and values are the max sums.
     */
    private Map<Integer, Integer> dfs(int u, int[] vals, List<Integer>[] adj) {
        // du: The DP map for the subtree at node u.
        // Key: bitmask of digits. Value: max sum for that combination of digits.
        Map<Integer, Integer> du = new HashMap<>();
        // Base case: A sum of 0 is possible with an empty set of digits (mask 0).
        du.put(0, 0);

        // Process the current node's value.
        String s = String.valueOf(Math.abs(vals[u]));
        if (hasUniqueDigits(s)) {
            int mask = 0;
            for (char c : s.toCharArray()) {
                mask |= (1 << (c - '0'));
            }
            du.put(mask, vals[u]);
        }

        // Recursively call DFS for all children and merge their results.
        for (int v : adj[u]) {
            Map<Integer, Integer> dv = dfs(v, vals, adj); // Results from child subtree.

            // To avoid ConcurrentModificationException, we iterate over a snapshot of the current
            // map `du` while potentially updating it. This mimics Python's `list(d.items())`.
            Map<Integer, Integer> duSnapshot = new HashMap<>(du);

            for (Map.Entry<Integer, Integer> entryV : dv.entrySet()) {
                int mv = entryV.getKey();
                int sv = entryV.getValue();

                for (Map.Entry<Integer, Integer> entryU : duSnapshot.entrySet()) {
                    int mu = entryU.getKey();
                    int su = entryU.getValue();

                    // If the digit sets are disjoint (no common bits in masks), we can combine them.
                    if ((mu & mv) == 0) {
                        int newMask = mu | mv;
                        int newSum = su + sv;
                        // Update `du` with the best possible sum for the new combined mask.
                        du.put(newMask, Math.max(du.getOrDefault(newMask, Integer.MIN_VALUE), newSum));
                    }
                }
            }
        }

        // After processing all children, the max value in `du` is the "good" sum for the subtree at u.
        // Initialize with a very small number to correctly find the maximum, even if sums are negative.
        int maxSubtreeSum = Integer.MIN_VALUE;
        for (int sum : du.values()) {
            maxSubtreeSum = Math.max(maxSubtreeSum, sum);
        }

        // Add this subtree's best sum to the total answer.
        // If du is empty (should not happen due to {0:0}), we add 0.
        this.ans += (maxSubtreeSum == Integer.MIN_VALUE ? 0 : maxSubtreeSum);

        return du;
    }

    /**
     * Helper function to check if a string contains only unique digits.
     *
     * @param s The string to check.
     * @return True if all characters are unique, false otherwise.
     */
    private boolean hasUniqueDigits(String s) {
        Set<Character> digits = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!digits.add(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution4 obj = new Solution4();
        System.out.println(obj.goodSubtreeSum(new int[]{12,18}, new int[]{-1,0}));
    }
}
