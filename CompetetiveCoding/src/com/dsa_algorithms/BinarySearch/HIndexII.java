package com.dsa_algorithms.BinarySearch;

public class HIndexII {
    public int hIndex(int[] citations) {
        int low = 0, mid, high = citations.length, ans = 0;

        while(low <= high){
            mid = (low+high)>>1;
            if(getHIndex(citations, mid) >= mid){
                ans = mid;
                low = mid+1;
            }
            else
                high = mid-1;
        }
        return ans;
    }
    public int getHIndex(int[] citations, int tar){
        int low = 0, mid, high = citations.length-1, ans = citations.length;

        while(low <= high){
            mid = (low+high) >> 1;
            if(citations[mid] >= tar){
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return citations.length-ans;
    }
}
