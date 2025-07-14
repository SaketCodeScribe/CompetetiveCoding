package com.dsa_algorithms.SegmentTree;

public class Solution2 {
    public static void main(String[] args) {
        int[] arr = new int[100], tree = new int[400];
        buildTree(arr, tree, 0, tree.length-1, 0);
    }
    private static void buildTree(int[] arr, int[] tree, int left, int right, int treeIndex){
        if (left == right){
            tree[treeIndex] = arr[left];
            return;
        }
        int mid = left + (right-left)/2;
        buildTree(arr, tree, left, mid, 2*treeIndex+1);
        buildTree(arr, tree, mid+1, right, 2*treeIndex+2);
        tree[treeIndex] = Math.min(tree[2*treeIndex+1], tree[2*treeIndex+2]);
    }
    private static int rangeQuery(int[] tree, int left, int right, int lq, int rq, int treeIndex){
        if (lq > right || rq < left){
            return Integer.MAX_VALUE;
        }
        if (lq <= left && rq >= right){
            return tree[treeIndex];
        }
        int mid = left+(right-left)/2;
        int leftVal = rangeQuery(tree, left, mid, lq, rq, 2*treeIndex+1);
        int rightVal = rangeQuery(tree, mid+1, right, lq, rq, 2*treeIndex+2);
        return Math.min(leftVal, rightVal);
    }
}
