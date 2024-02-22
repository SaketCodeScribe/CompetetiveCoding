package com.dsa_algorithms.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumZero {
    public static List<List<Integer>> triplet(int n, int[] arr) {
        // Write your code here.
        int i, j, k;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        i = 0;
        while (i < n) {
            j = i + 1;
            k = n - 1;
            while (j < k) {
                if (arr[i] + arr[j] + arr[k] > 0)
                    k--;
                else if (arr[i] + arr[j] + arr[k] < 0)
                    j++;
                else {
                    ans.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    while (j < k && arr[j] == arr[j - 1])
                        j++;
                    while (j < k && arr[k] == arr[k - 1])
                        k--;
                    k--;
                }
            }
            i++;
            while (i < n && arr[i] == arr[i - 1])
                i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(triplet(113, new int[]{3, -9, 3, 9, -6, -1, -2, 8, 6, -7, -14, -15, -7, 5, 2, -7, -4, 2, -12, -7, -1, -2, 1, -15, -13, -4, 0, -9, -11, 7, 4, 7, 13, 14, -7, -8, -1, -2, 7, -10, -2, 1, -10, 6, -9, -1, 14, 2, -13, 9, 10, -7, -8, -4, -14, -5, -1, 1, 1, 4, -15, 13, -12, 13, 12, -11, 12, -12, 2, -3, -7, -14, 13, -9, 7, -11, 5, -1, -2, -1, -7, -7, 0, -7, -4, 1, 3, 3, 9, 11, 14, 10, 1, -13, 8, -9, 13, -2, -6, 1, 10, -5, -6, 0, 1, 8, 4, 13, 14, 9, -2, -15, -13}));
    }
}
