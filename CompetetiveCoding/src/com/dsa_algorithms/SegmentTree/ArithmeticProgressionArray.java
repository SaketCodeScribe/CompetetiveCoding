package com.dsa_algorithms.SegmentTree;

public class ArithmeticProgressionArray {
    static class Pair {
        long a, d;
        public Pair(long a, long d) {
            this.a = a;
            this.d = d;
        }
    }

    long[] tree;
    Pair[] auxTree;
    int n;

    ArithmeticProgressionArray(int[] arr) {
        n = arr.length;
        tree = new long[4 * n + 1];
        auxTree = new Pair[4 * n + 1];
        for (int i = 0; i <= 4 * n; i++) {
            auxTree[i] = new Pair(0, 0);
        }
        buildTree(arr, auxTree, tree, 0, n - 1, 1);
    }

    private void buildTree(int[] arr, Pair[] auxTree, long[] tree, int left, int right, int treeIndex) {
        if (left == right) {
            tree[treeIndex] = arr[left];
            return;
        }
        int mid = left + (right - left) / 2;
        buildTree(arr, auxTree, tree, left, mid, 2 * treeIndex);
        buildTree(arr, auxTree, tree, mid + 1, right, 2 * treeIndex + 1);
        tree[treeIndex] = tree[2 * treeIndex] + tree[2 * treeIndex + 1];
    }

    public void update(int l, int r, int val) {
        update(tree, auxTree, 1, n, l, r, val, 1);
    }

    private void update(long[] tree, Pair[] auxTree, int left, int right, int lu, int ru, long val, int treeIndex) {
        Pair pair = auxTree[treeIndex];
        int mid = left + (right - left) / 2;
        int len = right - left + 1;

        if (pair.a != 0 || pair.d != 0) {
            long a = pair.a, d = pair.d;
            tree[treeIndex] += getSum(len, a, d);
            if (left != right) {
                auxTree[2 * treeIndex].a += a;
                auxTree[2 * treeIndex].d += d;
                auxTree[2 * treeIndex + 1].a += a + (mid - left + 1) * d;
                auxTree[2 * treeIndex + 1].d += d;
            }
            pair.a = pair.d = 0;
        }

        if (ru < left || lu > right) {
            return;
        }

        if (lu <= left && ru >= right) {
            int currLen = left-lu;
            tree[treeIndex] += getSum(len, val+currLen, 1);
            if (left != right) {
                auxTree[2 * treeIndex].a += val+currLen;
                auxTree[2 * treeIndex].d += 1;
                auxTree[2 * treeIndex + 1].a += val + currLen+(mid - left + 1) * 1L;
                auxTree[2 * treeIndex + 1].d += 1;
            }
            return;
        }

        update(tree, auxTree, left, mid, lu, ru, val, 2 * treeIndex);
        update(tree, auxTree, mid + 1, right, lu, ru, val, 2 * treeIndex + 1);
        tree[treeIndex] = tree[2 * treeIndex] + tree[2 * treeIndex + 1];
    }

    private static long getSum(long len, long a, long d) {
        return (len * (2 * a + (len - 1) * d)) / 2;
    }

    public long rangeSum(int l, int r) {
        return rangeSum(tree, auxTree, 1, n, l, r, 1);
    }

    private long rangeSum(long[] tree, Pair[] auxTree, int left, int right, int l, int r, int treeIndex) {
        Pair pair = auxTree[treeIndex];
        int mid = left + (right - left) / 2;
        int len = right - left + 1;

        if (pair.a != 0 || pair.d != 0) {
            long a = pair.a, d = pair.d;
            tree[treeIndex] += getSum(len, a, d);
            if (left != right) {
                auxTree[2 * treeIndex].a += a;
                auxTree[2 * treeIndex].d += d;
                auxTree[2 * treeIndex + 1].a += a + (mid - left + 1) * d;
                auxTree[2 * treeIndex + 1].d += d;
            }
            pair.a = pair.d = 0;
        }

        if (r < left || l > right) {
            return 0;
        }

        if (l <= left && r >= right) {
            return tree[treeIndex];
        }

        long leftVal = rangeSum(tree, auxTree, left, mid, l, r, 2 * treeIndex);
        long rightVal = rangeSum(tree, auxTree, mid + 1, right, l, r, 2 * treeIndex + 1);
        return leftVal + rightVal;
    }
}