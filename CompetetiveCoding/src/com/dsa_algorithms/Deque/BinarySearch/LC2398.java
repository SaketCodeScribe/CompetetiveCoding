package com.dsa_algorithms.Deque.BinarySearch;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC2398 {
    static class SegmentTree{
        int[] tree;
        public SegmentTree(int n, int[] arr){
            tree = new int[4*n];
            createTree(arr, 0, n-1, 0);
        }
        private void createTree(int[] arr, int l, int r, int i){
            if (l == r){
                tree[i] = arr[l];
            }
            else{
                int mid = l + (r-l)/2;
                createTree(arr, l, mid, 2*i+1);
                createTree(arr, mid+1, r, 2*i+2);
                tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
            }
        }
        public int rangeQuery(int l, int r, int ql, int qr, int i){
            if (ql <= l && qr >= r) return tree[i];
            if (ql > r || qr < l) return Integer.MIN_VALUE;
            int mid = l + (r-l)/2;
            return Math.max(rangeQuery(l, mid, ql, qr, 2*i+1), rangeQuery(mid+1, r, ql, qr, 2*i+2));
        }
    }
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int i, n = chargeTimes.length, low = 1, high = n, ans = 0;
        SegmentTree sTree = new SegmentTree(n, chargeTimes);
        long[] prefixSum = new long[n];

        for(i = 0; i<n; i++){
            prefixSum[i] = (i > 0 ? prefixSum[i-1] : 0l) + runningCosts[i];
        }

        while(low <= high){
            int mid = low + (high-low)/2;
//            if (getBudget(sTree, prefixSum, mid, n, budget)) -- with segmentTree
            if (getBudget(chargeTimes, prefixSum, mid, n, budget)){ // with monotonic deque
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
    private boolean getBudget(SegmentTree tree, long[] sum, int noOfRobots, int n, long budget){
        int i;

        for(i=0; i+noOfRobots<=n; i++){
            long cost = tree.rangeQuery(0, n-1, i, i+noOfRobots-1, 0) + noOfRobots * (sum[i+noOfRobots-1] - (i > 0 ? sum[i-1] : 0));
            if (cost <= budget) return true;
        }
        return false;
    }
    private boolean getBudget(int[] chargeTimes, long[] sum, int noOfRobots, int n, long budget) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && chargeTimes[deque.peekLast()] <= chargeTimes[i]) {
                deque.pollLast();
            }
            deque.addLast(i);

            while (!deque.isEmpty() && deque.peekFirst() < i - noOfRobots + 1) {
                deque.pollFirst();
            }

            if (i >= noOfRobots - 1) {
                int start = i - noOfRobots + 1;
                long windowSum = sum[i] - (start > 0 ? sum[start - 1] : 0);
                assert !deque.isEmpty();
                long cost = chargeTimes[deque.peekFirst()] + noOfRobots * windowSum;

                if (cost <= budget) return true;
            }
        }
        return false;
    }
}

