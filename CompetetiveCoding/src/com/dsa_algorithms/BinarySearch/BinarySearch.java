package com.dsa_algorithms.BinarySearch;

public class BinarySearch {
    public static int implementLowerBound(int[] arr, int n, int x){
        int low = 0, high = n-1, mid, ans = n;
        while (low<=high){
            mid = low+(high-low)/2;
            if (arr[mid] > x){
                high = mid-1;
                ans = mid;
            }
            else
                low = mid+1;
        }
        return ans;
    }

    public static int implementUpperBound(int[] arr, int n, int x){
        int low = 0, high = n-1, mid, ans = n;

        while(low <= high){
            mid = low+(high-low)/2;
            if (arr[mid] >= x){
                high = mid-1;
                if (arr[mid] > x)
                    ans = mid;
            }
            else
                low = mid+1;
        }
        return ans;
    }

    public static void main(String[] args){
        int[] arr = new int[] {1,1,2,5,7};
        int n = 1, x = 2;
        /*
            implements Lower Bound
         */
        System.out.println(implementLowerBound(arr, n, x));

        /*
            implements Upper Bound
         */
        System.out.println(implementUpperBound(arr, n, x));
    }
}
