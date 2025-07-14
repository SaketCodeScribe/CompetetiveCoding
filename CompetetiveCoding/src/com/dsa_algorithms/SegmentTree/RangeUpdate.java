package com.dsa_algorithms.SegmentTree;

public class RangeUpdate {
    public static void main(String[] args) {
        int[] arr = new int[100], tree = new int[400], auxTree = new int[400];
        int lq = 4, rq = 79;
        int lu = 56, ru = 67, val = 5;
        buildTree(arr, tree, 0, arr.length-1, 0);
        rangeQuery(tree, auxTree,0, arr.length-1, lq, rq, 0);
        rangeUpdate(tree, auxTree, 0, arr.length-1, lu, ru, val, 0);
    }

    private static void rangeUpdate(int[] tree, int[] auxTree, int left, int right, int lu, int ru, int val,
                                    int treeIndex) {
        tree[treeIndex] += auxTree[treeIndex]*(right-left+1);
        if (left != right) {
            auxTree[2 * treeIndex + 1] += auxTree[treeIndex];
            auxTree[2 * treeIndex + 2] += auxTree[treeIndex];
        }
        auxTree[treeIndex] = 0;
        if (lu > right || ru < left){
            return;
        }
        if (lu <= left && ru >= right){
            tree[treeIndex] += val*(right-left+1);
            if (left != right) {
                auxTree[2 * treeIndex + 1] += val;
                auxTree[2 * treeIndex + 2] += val;
            }
            return;
        }
        int mid = left+(right-left)/2;
        rangeUpdate(tree, auxTree, left, mid, lu, ru, val, 2*treeIndex+1);
        rangeUpdate(tree, auxTree, mid+1, right, lu, ru, val, 2*treeIndex+2);
        tree[treeIndex] = tree[2*treeIndex+1] + tree[2*treeIndex+2];
    }

    private static void buildTree(int[] arr, int[] tree, int left, int right, int treeIndex){
        if (left == right){
            tree[treeIndex] = arr[left];
            return;
        }
        int mid = left+(right-left)/2;
        buildTree(arr, tree, left, mid, 2*treeIndex+1);
        buildTree(arr, tree, mid+1, right, 2*treeIndex+2);
        tree[treeIndex] = tree[2*treeIndex+1] + tree[2*treeIndex+2];
    }
    private static int rangeQuery(int[] tree, int[] auxTree, int left, int right, int lq, int rq, int treeIndex){
        tree[treeIndex] += auxTree[treeIndex]*(right-left+1);
        if (left != right) {
            auxTree[2 * treeIndex + 1] += auxTree[treeIndex];
            auxTree[2 * treeIndex + 2] += auxTree[treeIndex];
        }
        auxTree[treeIndex] = 0;
        if (rq < left || lq > right){
            return 0;
        }
        if (lq <= left && rq >= right){
            return tree[treeIndex];
        }
        int mid = left+(right-left)/2;
        int leftVal = rangeQuery(tree, auxTree,left, mid, lq, rq, 2*treeIndex+1);
        int rightVal = rangeQuery(tree, auxTree, mid+1, right, lq, rq, 2*treeIndex+2);
        return leftVal+rightVal;
    }
}
