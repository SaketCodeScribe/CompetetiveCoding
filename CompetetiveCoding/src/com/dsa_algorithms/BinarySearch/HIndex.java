package com.dsa_algorithms.BinarySearch;

public class HIndex {
    public int hIndex(int[] citations) {
        int low = 0, mid, high = citations.length, ans = 1;

        while(low<=high){
            mid = (low+high)>>1;
            if (getHIndex(citations, mid) >= mid){
                ans = mid;
                low = mid+1;
            }
            else
                high = mid-1;
        }
        return ans;
    }
    public int getHIndex(int[] citations, int tar){
        int cnt = 0;
        for(int cite:citations)
            if (cite >= tar)
                cnt++;
        return cnt;
    }
}
