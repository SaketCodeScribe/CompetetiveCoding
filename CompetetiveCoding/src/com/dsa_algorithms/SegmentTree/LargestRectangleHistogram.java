package com.dsa_algorithms.SegmentTree;
import java.util.*;

public class LargestRectangleHistogram {
    static int[] tree;
    public static int buildTree(int i, int l, int r, ArrayList<Integer> nums){
        if (l == r)
            return tree[i] = l;
        int mid = l+(r-l)/2;
        int left = buildTree(2*i+1, l, mid, nums);
        int right = buildTree(2*i+2, mid+1, r, nums);
        return tree[i] = nums.get(left) > nums.get(right) ?  right : left;
    }
    public static int largestRectangle(ArrayList < Integer > heights) {
        // Write your code here.
        int n = heights.size();
        tree = new int[4*n];
        buildTree(0, 0, n-1, heights);
        return getLargestRectangle(0, n - 1, heights);
    }
    static int getLargestRectangle(int start, int end, ArrayList<Integer> heights){
        if (start > end)
            return 0;
        int minIndex = query(0, 0, heights.size() - 1, start, end, heights);
        int areaWithMinHeight = heights.get(minIndex) * (end - start + 1);
        int areaLeft = getLargestRectangle(start, minIndex - 1, heights);
        int areaRight = getLargestRectangle(minIndex + 1, end, heights);
        return Math.max(areaWithMinHeight, Math.max(areaLeft, areaRight));
    }

    static int query(int i, int l, int r, int ql, int qr, ArrayList<Integer> heights) {
        if (ql <= l && qr >= r)
            return tree[i];
        if (qr < l || ql > r)
            return -1;
        int mid = l + (r - l) / 2;
        int left = query(2 * i + 1, l, mid, ql, qr, heights);
        int right = query(2 * i + 2, mid + 1, r, ql, qr, heights);
        if (left == -1) return right;
        if (right == -1) return left;
        return heights.get(left) < heights.get(right) ? left : right;
    }
}
