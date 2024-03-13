package com.dsa_algorithms.BinarySearch;

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        if (k < arr[0])
            return k;
        int lo=0, mid, hi, n = arr.length;
        hi = n-1;

        while (lo <= hi){
            mid = lo+(hi-lo)/2;
            int missing = arr[mid]-mid-1;
            if (missing < k){
                lo = mid+1;
            }
            else
                hi = mid-1;
        }
        return lo+k;
    }
}
