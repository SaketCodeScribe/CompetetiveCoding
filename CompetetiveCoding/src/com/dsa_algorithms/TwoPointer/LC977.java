package com.dsa_algorithms.TwoPointer;

public class LC977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length, i = 0, mid = findPivot(nums, n), left = mid-1, right = mid;
        int[] ans = new int[n];

        while(i < n) {
            if (right >= n) ans[i++] = nums[left]*nums[left--];
            else if (left < 0 ) ans[i++] = nums[right]*nums[right++];
            else {
                if (Math.abs(nums[left]) > nums[right]) {
                    ans[i++] = nums[right]*nums[right++];
                } else ans[i++] = nums[left]*nums[left--];
            }
        }
        return ans;
    }
    private int findPivot(int[] nums, int n) {
        int low = 0, high = n-1, mid, ans = n;

        while(low <= high) {
            mid = low + (high-low)/2;

            if (nums[mid] >= 0) {
                ans = mid;
                high = mid-1;
            } else low = mid+1;
        }
        return ans;
    }
}
