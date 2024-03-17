package com.dsa_algorithms.TwoPointer;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {
    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        // Write your code here.
        int i, j, m = a.length, n = b.length;
        i = m-1;
        j = 0;

        while(i >=0 && j < n && a[i] > b[j]){
            swap(a,b,i,j);
            i--;
            j++;
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
    static void swap(long[] a, long[] b, int i, int j){
        long temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }
}
