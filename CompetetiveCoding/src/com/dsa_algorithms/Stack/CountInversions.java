package com.dsa_algorithms.Stack;

public class CountInversions {
    static long ans;
    public static long[] mergeSort(long[] arr, int l, int h){
        if (l == h)
            return new long[]{arr[l]};
        int mid = l+(h-l)/2;
        long[] left = mergeSort(arr, l, mid);
        long[] right = mergeSort(arr, mid+1, h);
        return merge(left, right);
    }
    public static long[] merge(long[] left, long[] right){
        int k = 0, m = left.length, n = right.length, i = 0, j = 0;
        long[] res = new long[m+n];

        while (i < m && j < n){
            if (left[i] > right[j]){
                ans += m-i;
                res[k++] = right[j++];
            }
            else
                res[k++] = left[i++];

        }
        while (i<m)
            res[k++] = left[i++];
        while (j<n)
            res[k++] = right[j++];
        return res;
    }
    public static long getInversions(long arr[], int n) {
        ans = 0;
        mergeSort(arr, 0, n-1);
        return ans;
    }
}
