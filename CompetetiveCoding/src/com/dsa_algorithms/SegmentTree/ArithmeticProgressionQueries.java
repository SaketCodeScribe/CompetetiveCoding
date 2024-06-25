package com.dsa_algorithms.SegmentTree;

import java.util.*;
public class ArithmeticProgressionQueries {
    static class Pair{
        long a, d;
        public Pair(long a, long d){
            this.a = a;
            this.d = d;
        }
    }

    long[] tree;
    Pair[] lazyTree;
    int n;
    // Initialize here
    public ArithmeticProgressionQueries(int[] arr) {
        // Write your code here
        n = arr.length;
        tree = new long[4*n];
        lazyTree = new Pair[4*n];
        for(int i=0; i<4*n; i++)
            lazyTree[i] = new Pair(0, 0);
        buildTree(0, 0, n-1, arr);
    }

    // Update operation
    public void update(int l, int r, int val) {
        // Write your code here
        update(0, l-1, r-1, 0, n-1, val);
    }

    // Return the sum of subarray arr[l..r]
    public long rangeSum(int l, int r) {
        // Write your code here
        return rangeSum(0, l-1, r-1, 0, n-1);

    }
    private long getSum(long a, long d, int s, int e){
        int n = e-s+1;
        return (n*(2*a+(n-1)*d))/2;
    }

    private void lazyUpdate(int i, int s, int e){
        int mid = (s+e)>>1;
        long a = lazyTree[i].a, d = lazyTree[i].d;
        tree[i] += getSum(a, d, s, e);
        if (s != e){
            lazyTree[2*i+1].a += a;
            lazyTree[2*i+1].d += d;
            lazyTree[2*i+2].a += a+(mid-s+1)*d;
            lazyTree[2*i+2].d += d;
        }
        lazyTree[i].a = lazyTree[i].d = 0;
    }

    public void buildTree(int i, int l, int r, int[] arr){
        if (l == r){
            tree[i] = arr[l];
            return;
        }
        int mid = (l+r)>>1;
        buildTree(2*i+1, l, mid, arr);
        buildTree(2*i+2, mid+1, r, arr);
        tree[i] = tree[2*i+1]+tree[2*i+2];
    }

    public long rangeSum(int i, int l, int r, int s, int e){
        if (s > e)
            return 0l;

        if (lazyTree[i].a != 0 || lazyTree[i].d != 0)
            lazyUpdate(i, s, e);

        if (Math.max(l,s) > Math.min(r,e))
            return 0l;

        if (l <= s && r >= e)
            return tree[i];

        int mid = (s+e)>>1;

        return rangeSum(2*i+1, l, r, s, mid) + rangeSum(2*i+2, l, r, mid+1, e);
    }

    public void update(int i, int l, int r, int s, int e, int val){
        if (s > e)
            return;

        if (lazyTree[i].a != 0 || lazyTree[i].d != 0)
            lazyUpdate(i, s, e);

        if (Math.max(l,s) > Math.min(r,e))
            return;
        int mid = (s+e)>>1;
        if (l <= s && r >= e){
            tree[i] += getSum(val, 1, s, e);
            if (s != e){
                lazyTree[2*i+1].a += val;
                lazyTree[2*i+1].d++;
                lazyTree[2*i+2].a += val+(mid-s+1)*1;
                lazyTree[2*i+2].d++;
            }
            return;
        }
        update(2*i+1, l, r, s, mid, val);
        int beg = Math.max(l, s);
        if (beg <= mid)
            val += mid-beg+1;
        update(2*i+2, l, r, mid+1, e, val);
        tree[i] = tree[2*i+1]+tree[2*i+2];
    }
}

