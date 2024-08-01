package com.dsa_algorithms.DivideAndConquer.searching;

public class PeakIndex {
    public int peakIndexInMountainArray(int[] arr) {
        int ans = 0, low = 0, high = arr.length-1, mid;

        while(low <= high){
            mid = (low+high)>>1;
            if (mid == 0 || arr[mid] >= arr[mid-1]){
                low = mid+1;
                ans = mid;
            }
            else
                high = mid-1;
        }
        return ans;
    }
}
