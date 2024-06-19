package com.dsa_algorithms.DivideAndConquer;

public class KthEltOfTwoSortedArrays {
    public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k) {
        // Write your code here.
        if (m > n)
            return ninjaAndLadoos(row2, row1, n, m, k);
        int low = 0, high = m, mid;

        while(low <= high){
            mid = (low+high) >> 1;
            int aleft = mid > 0 ? row1[mid-1] : Integer.MIN_VALUE;
            int aright = m-mid > 0 ? row1[mid] : Integer.MAX_VALUE;
            int bleft = k-mid > n ? Integer.MAX_VALUE : (k-mid <= 0 ? Integer.MIN_VALUE : row2[k-mid-1]);
            int bright = n-k+mid >= n ? Integer.MIN_VALUE : (n-k+mid <= 0 ? Integer.MAX_VALUE : row2[k-mid]);
            if (aleft <= bright && bleft <= aright)
                return Math.max(aleft, bleft);
            if (aleft > bright)
                high = mid-1;
            else
                low = mid+1;
        }
        return 0;
    }
}
