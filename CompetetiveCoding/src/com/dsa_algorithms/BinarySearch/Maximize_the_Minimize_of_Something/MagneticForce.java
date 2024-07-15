package com.dsa_algorithms.BinarySearch.Maximize_the_Minimize_of_Something;

import java.util.*;
public class MagneticForce {
    public int maxDistance(int[] position, int m) {
        int low = 1, high, mid, n = position.length, ans = 1;
        Arrays.sort(position);
        high = (position[n-1]-position[0])/(m-1)+1; // bound by dividing the space equi-distant.

        while(low <= high){
            mid = (low+high) >> 1;
            int cnt = getM(mid, m, n, position);
            if (cnt >= m){
                ans = mid;
                low = mid+1;
            }
            else
                high = mid-1;
        }
        return ans;
    }
    public int getM(int force, int m, int n, int[] pos){
        int i, cnt = 1, lastPos = 0;

        for(i=1; i <n; i++){
            if (pos[i]-pos[lastPos] >= force){
                cnt++;
                lastPos = i;
            }
        }
        return cnt;
    }
}
