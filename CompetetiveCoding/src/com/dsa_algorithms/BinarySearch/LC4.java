package com.dsa_algorithms.BinarySearch;

public class LC4 {
    // O(log(min(m, n))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;

        if (m > n) return findMedianSortedArrays(nums2, nums1);
        int low = 0, high = m;

        while(low <= high){
            int partitionA = low + (high-low)/2;
            int partitionB = (m+n+1)/2 - partitionA;

            int maxLeftA = partitionA == 0 ? Integer.MIN_VALUE : nums1[partitionA-1];
            int minRightA = partitionA == m ? Integer.MAX_VALUE : nums1[partitionA];

            int maxLeftB = partitionB == 0 ? Integer.MIN_VALUE : nums2[partitionB-1];
            int minRightB = partitionB == n ? Integer.MAX_VALUE : nums2[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA){
                if ((m + n) % 2 == 0) {
                    return (
                            (Math.max(maxLeftA, maxLeftB) +
                                    Math.min(minRightA, minRightB)) /
                                    2.0
                    );
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            }
            else if (maxLeftA > minRightB) high = partitionA-1;
            else low = partitionA + 1;
        }
        return 0d;
    }
    // O(log m * log n)
    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;

            return (m+n)%2 == 0 ? (findKthSmallestElement(nums1, nums2, 0, m-1, 0, n-1, (m+n)/2) + findKthSmallestElement(nums1, nums2, 0, m-1, 0, n-1, (m+n)/2+1)) / 2 :
                    findKthSmallestElement(nums1, nums2, 0, m-1, 0, n-1, (m+n)/2+1);
        }

        private double findKthSmallestElement(int[] nums1, int[] nums2, int l1, int h1, int l2, int h2, int k){
            if (l1 > h1) return nums2[l2+k-1];
            if (l2 > h2) return nums1[l1+k-1];

            if (h1-l1 > h2 - l2) return findKthSmallestElement(nums2, nums1, l2, h2, l1, h1, k);

            int mid = l1+(h1-l1)/2;
            int index = binarySearchIndex(nums2, l2, h2, nums1[mid]);
            int leftCnt = mid-l1+1 + index-l2+1;
            if (leftCnt == k) return nums1[mid];
            if (leftCnt > k){
                return findKthSmallestElement(nums1, nums2, l1, mid-1, l2, index, k);
            }
            else return findKthSmallestElement(nums1, nums2, mid+1, h1, index+1, h2, k-leftCnt);
        }

        private int binarySearchIndex(int[] arr, int low, int high, int tar){
            int mid, ans = low-1;

            while(low <= high){
                mid = low + (high-low)/2;
                if (arr[mid] <= tar){
                    ans = mid;
                    low = mid+1;
                }
                else high = mid-1;
            }
            return ans;
        }
    }
}
