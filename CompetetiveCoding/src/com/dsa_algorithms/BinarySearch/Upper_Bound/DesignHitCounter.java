package com.dsa_algorithms.BinarySearch.Upper_Bound;

import java.util.*;
public class DesignHitCounter {
    List<int[]> list;

    public DesignHitCounter() {
        list = new ArrayList<>();
    }

    public void hit(int timestamp) {
        if (list.isEmpty() || list.get(list.size()-1)[0] < timestamp)
            list.add(new int[]{timestamp, 1});
        else
            list.get(list.size()-1)[1]++;

    }

    public int getHits(int timestamp) {
        int ans = 0;
        int i = findUpperBound(timestamp-300);

        while(i < list.size() && list.get(i)[0] > timestamp-300 & list.get(i)[0] <= timestamp){
            ans += list.get(i++)[1];
        }
        return ans;
    }

    public int findUpperBound(int tar){
        int low = 0, high = list.size()-1, ans = list.size(), mid;

        while(low <= high){
            mid = (low+high) >> 1;
            if (list.get(mid)[0] <= tar)
                low = mid+1;
            else{
                high = mid-1;
                ans = mid;
            }
        }
        return ans;
    }
}
