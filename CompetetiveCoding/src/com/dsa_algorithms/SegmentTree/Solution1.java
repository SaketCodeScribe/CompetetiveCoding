package com.dsa_algorithms.SegmentTree;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] tree = new int[4*n];
        buildTree(arr, tree, 0, arr.length-1, 0);

        while(m-- > 0){
            char ch = scanner.next().charAt(0);
            if (ch == 'q') {
                int lq = scanner.nextInt()-1;;
                int rq = scanner.nextInt()-1;
                System.out.println(rangeQuery(tree, 0, n-1, 0, lq, rq));
            }
            else{
                int index = scanner.nextInt()-1;
                int val = scanner.nextInt();
                updateSingleElement(arr, tree, 0, n-1, 0, index, val);
            }
        }
    }

    private static void buildTree(int[] arr, int[] tree, int left, int right, int treeIndex){
        if (left == right){
            tree[treeIndex] = arr[left];
            return;
        }
        buildTree(arr, tree, left, left+(right-left)/2, treeIndex*2+1);
        buildTree(arr, tree, left+(right-left)/2+1, right, treeIndex*2+2);
        tree[treeIndex] = Math.min(tree[2*treeIndex+1], tree[2*treeIndex+2]);
        return;
    }
    private static void updateSingleElement(int[] arr, int[] tree, int left, int right, int treeIndex, int updateIndex,
                                            int val){
        if (left == right){
            tree[treeIndex] = arr[left] = val;
            return;
        }
        int mid = left+(right-left)/2;

        if (updateIndex <= mid){
            updateSingleElement(arr, tree, left, mid, 2*treeIndex+1, updateIndex, val);
        }
        else{
            updateSingleElement(arr, tree, mid+1, right, 2*treeIndex+2, updateIndex, val);
        }
        tree[treeIndex] = Math.min(tree[2*treeIndex+1], tree[2*treeIndex+2]);
    }
    private static int rangeQuery(int[] tree, int left, int right, int treeIndex, int lq, int rq){
        if (lq <= left && rq >= right){
            return tree[treeIndex];
        }
        if (Math.min(right, rq) < Math.max(left, lq)){
            return Integer.MAX_VALUE;
        }
        int mid = left+(right-left)/2;
        int leftRange = rangeQuery(tree, left, mid, 2*treeIndex+1, lq, rq);
        int rightRange = rangeQuery(tree, mid+1, right, 2*treeIndex+2, lq, rq);
        return Math.min(leftRange, rightRange);
    }
}
