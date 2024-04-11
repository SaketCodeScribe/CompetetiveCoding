package com.dsa_algorithms.SegmentTree;

import java.util.Arrays;

public class SegmentTree {
    static int[] tree;
    public static int buildTree(int i, int l, int r, int[] nums){
        if (l == r)
            return tree[i] = nums[l];
        int mid = l+(r-l)/2;
        return tree[i] = buildTree(2*i+1, l, mid, nums)+buildTree(2*i+2, mid+1, r, nums);
    }
    private static int getSum(int i, int x, int y, int l, int r) {
        if (Math.max(l,x) > Math.min(r,y))
            return 0;
        if (l>=x && r<=y)
            return tree[i];
        int mid = l+(r-l)/2;
        return getSum(2*i+1, x, y, l, mid)+getSum(2*i+2, x, y, mid+1, r);
    }
    private static void update(int i, int val, int ind, int l, int r) {
        if (l == r) {
            tree[ind] = val;
            return;
        }
        int mid = l +(r-l)/2;
        if (mid >= i)
            update(i, val, 2*ind+1, l, mid);
        else
            update(i, val, 2*ind+2, mid+1, r);
        tree[ind] = tree[2*ind+1]+tree[2*ind+2];
    }
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,5,6,7,2,8};
        tree = new int[2*nums.length];
        SegmentTree.buildTree(0, 0, nums.length-1, nums);
        System.out.println(Arrays.deepToString(new Object[]{tree}));
        SegmentTree.update(3, 7, 0, 0, nums.length-1);
        System.out.println(Arrays.deepToString(new Object[]{tree}));
        System.out.println(SegmentTree.getSum(0,1,6,0,nums.length-1));
        System.out.println(SegmentTree.getSum(0,0,9,0,nums.length-1));
        System.out.println(SegmentTree.getSum(0,7,8,0,nums.length-1));
        System.out.println(SegmentTree.getSum(0,3,8,0,nums.length-1));
        System.out.println(SegmentTree.getSum(0,5,5,0,nums.length-1));
    }
}
