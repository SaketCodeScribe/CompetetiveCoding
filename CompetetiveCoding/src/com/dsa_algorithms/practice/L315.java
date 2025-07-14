package com.dsa_algorithms.practice;

import java.util.ArrayList;
import java.util.List;

public class L315 {
    private void buildTree(int[] arr, int[] tree, int left, int right, int treeIndex){
        if (left == right){
            tree[treeIndex] = arr[left];
            return;
        }

        int mid = left+(right-left)/2;
        buildTree(arr, tree, left, mid, 2*treeIndex);
        buildTree(arr, tree, mid+1, right, 2*treeIndex+1);
        tree[treeIndex] = tree[2*treeIndex] + tree[2*treeIndex+1];
    }
    private int rangeQuery(int[] tree, int left, int right, int lq, int rq, int treeIndex){
        if (rq < left || lq > right){
            return 0;
        }
        if (lq <= left && rq >= right){
            return tree[treeIndex];
        }
        int mid = left+(right-left)/2;
        int leftVal = rangeQuery(tree, left, mid, lq, rq, 2*treeIndex);
        int rightVal = rangeQuery(tree, mid+1, right, lq, rq, 2*treeIndex+1);
        return leftVal + rightVal;
    }
    private void update(int[] tree, int[] bucket, int left, int right, int index, int treeIndex){
        if (left == right){
            bucket[left]++;
            tree[treeIndex] = bucket[left];
            return;
        }
        int mid = left+(right-left)/2;
        if (index <= mid) {
            update(tree, bucket, left, mid, index, 2 * treeIndex);
        }
        else {
            update(tree, bucket, mid + 1, right, index, 2 * treeIndex + 1);
        }
        tree[treeIndex] = tree[2*treeIndex] + tree[2*treeIndex+1];
    }
    public List<Integer> countSmaller(int[] nums) {
        int i, n = nums.length-1;
        List<Integer> ans = new ArrayList<>();
        int[] bucket = new int[1_00_000_001];
        int[] tree = new int[4_00_000_001];
        buildTree(bucket, tree, 0, 1_00_000_000, 1);

        for(i=n-1; i>=0; i--){
            ans.add(rangeQuery(tree, 0, 1_00_000_000, 0, nums[i]-1+10_000, 1));
            update(bucket, tree, 0, 1_00_000_000, nums[i]+10_000, 1);
        }
        return ans;
    }
}
