package com.dsa_algorithms.Greedy;

import java.util.*;
public class LongestIncreasingSubsequence {
    static List<Integer> inc;
    public static int LIS(ArrayList<Integer> heights, int n)  {
        // Write your code here.
        int i = 0;
        inc = new ArrayList<>();
        while(i < n){
            if (i == 0 || heights.get(i) > inc.get(inc.size()-1))
                inc.add(heights.get(i));
            else{
                int pos = findUpperBound(heights.get(i));
                if (pos > heights.size())
                    inc.add(heights.get(i));
                else
                    inc.set(pos, heights.get(i));
            }
            i++;
        }
        return inc.size();
    }
    public static int findUpperBound(int tar){
        int low = 0, high = inc.size()-1, ans = -1;

        while(low <= high){
            int mid = (low+high)>>1;
            if (inc.get(mid) == tar)
                return low;
            if (inc.get(mid) > tar){
                ans = mid; high = mid-1;
            }
            else{
                if (ans == -1)
                    ans = mid;
                low = mid+1;
            }
        }
        return ans;
    }
}
