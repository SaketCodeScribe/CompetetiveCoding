package com.dsa_algorithms.SlidingWindow;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i, j, n = height.length, ans = 0;
        i = 0; j = n-1;

        while(i<j){
            ans = Math.max(ans, Math.min(height[i], height[j])*(j-i));
            if (height[i] < height[j])
                i++;
            else if (height[i] >= height[j])
                j--;
        }
        return ans;
    }
}
