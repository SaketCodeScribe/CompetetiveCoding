package com.dsa_algorithms.Recursion;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m, n;
        m = nums1.length;
        n = nums2.length;
        if(m == 0)
            return (n&1) > 0 ? nums2[n/2]:(nums2[n/2-1]+nums2[n/2])/2.0;
        if (n == 0)
            return (m&1) > 0 ? nums1[m/2] :(nums1[m/2-1]+nums1[m/2])/2.0;
        return ((m+n)&1) > 0 ? findMedian(nums1, nums2, 0, m-1, 0, n-1, (m+n)/2+1)
                : (findMedian(nums1, nums2, 0, m-1, 0, n-1, (m+n)/2+1)+
                findMedian(nums1, nums2, 0, m-1, 0, n-1, (m+n)/2))/2.0;

    }
    public int findMedian(int[] nums1, int[] nums2, int l1, int r1, int l2, int r2, int k){
        int la, mid1 = l1+(r1-l1+1)/2, lb, mid2 = l2+(r2-l2+1)/2;
        la = mid1-l1;
        lb = mid2-l2;

        if(la == 0){
            if (k==1)
                return Math.min(nums1[l1], nums2[l2]);
            if (nums1[l1] <= nums2[l2+k-2])
                return nums2[l2+k-2];
            if (l2+k-1 <= r2 && nums1[l1] > nums2[l2+k-1])
                return nums2[l2+k-1];
            return nums1[l1];
        }

        if(lb == 0){
            if (k==1)
                return Math.min(nums1[l1], nums2[l2]);
            if (nums1[l1+k-2] >= nums2[l2])
                return nums1[l1+k-2];
            if (l1+k-1 <= r1 && nums1[l1+k-1] < nums2[l2])
                return nums1[l1+k-1];
            return nums2[l2];
        }
        if(nums1[mid1] < nums2[mid2]){
            if (la+lb >= k)
                return findMedian(nums1, nums2, l1, r1, l2, mid2-1, k);
            else
                return findMedian(nums1, nums2, mid1, r1, l2, r2, k-la);
        }
        else{
            if (la+lb >= k)
                return findMedian(nums1, nums2, l1, mid1-1, l2, r2, k);
            else
                return findMedian(nums1, nums2, l1, r1, mid2, r2, k-lb);
        }
    }
}
