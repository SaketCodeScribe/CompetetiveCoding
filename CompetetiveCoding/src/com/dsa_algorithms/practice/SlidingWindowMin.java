package com.dsa_algorithms.practice;

import java.util.*;
import java.util.Scanner;

public class SlidingWindowMin {
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
        long ans = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        // Generate the sequence
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                sequence[i] = (a * sequence[i - 1] + b) % c;
            }
            while(!deque.isEmpty() && deque.peekFirst() <= i-k){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && sequence[deque.peekLast()] > sequence[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            if (i >= k-1) {
                ans ^= sequence[deque.peekFirst()];
            }
        }
//        System.out.println(getMinWindowUsingPriorityQueue(sequence, n, k));
//        System.out.println(getMinInWindowUsingSegmentTree(sequence, n, k));
        System.out.println(ans);
    }

    private static long getMinWindowUsingPriorityQueue(long[] sequence, int n, int k) {
        int left = 0;
        long ans = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[0], b[0]));

        for(int i=0; i<n; i++){
            while(!pq.isEmpty() && pq.peek()[1] <= i-k){
                pq.poll();
            }
            pq.add(new long[]{sequence[i], i});
            if (i >= k-1) {
                ans ^= pq.peek()[0];
            }
        }
        return ans;
    }

    private static long getMinInWindowUsingSegmentTree(long[] sequence, int n, int k) {
        int i;
        long ans = 0;
        long[] tree = new long[4*n];
        buildTree(tree, sequence, 0, n-1, 0);

        for(i=0; i<=n-k; i++){
            ans ^= rangeQuery(tree, 0, n-1, i, i+k-1, 0);
        }
        return ans;
    }

    private static long rangeQuery(long[] tree, int left, int right, int lq, int rq, int i) {
        if (rq < left || lq > right){
            return Integer.MAX_VALUE;
        }
        if (lq <= left && rq >= right){
            return tree[i];
        }
        int mid = left + (right-left)/2;
        return Math.min(rangeQuery(tree, left, mid, lq, rq, 2*i+1),
                rangeQuery(tree, mid+1, right, lq, rq, 2*i+2));
    }

    private static void buildTree(long[] tree, long[] arr, int left, int right, int i){
        if (left == right){
            tree[i] = arr[left];
            return;
        }
        int mid = left+(right-left)/2;
        buildTree(tree, arr, left, mid, 2*i+1);
        buildTree(tree, arr, mid+1, right, 2*i+2);
        tree[i] = Math.min(tree[2*i+1], tree[2*i+2]);
    }
}
