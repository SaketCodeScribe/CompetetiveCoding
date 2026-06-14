package com.dsa_algorithms.TwoPointer;

public class LC11 {
    public int maxArea(int[] height) {
        int n = height.length, left = 0, right = n-1;
        int ans = 0;

        while(left<right){
            ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]){
                do{
                    left++;
                }
                while(left < right && height[left-1] == height[left]);
            }
            else do{
                right--;
            }
            while(left < right && height[right+1] == height[right]);
        }
        return ans;
    }
}
