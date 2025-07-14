package com.dsa_algorithms.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L969 {
    public static void main(String[] args) {
        System.out.println(pancakeSort(new int[]{3,2,4,1}));
    }

    public static List<Integer> pancakeSort(int[] arr) {
        int i, n = arr.length-1;
        List<Integer> ans = new ArrayList<>();

        while(n >= 0){
            int max = 0;
            for(i=0; i<=n; i++){
                if (arr[i] > arr[max]){
                    max = i;
                }
            }
            if (max == 0){
                ans.add(n+1);
                for(i=0; i<(n+1)/2; i++){
                    swap(arr, i, n-i);
                }
                n--;
            }
            else{
                ans.add(max+1);
                for(i=0; i<(max+1)/2; i++){
                    swap(arr, i, max-i);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return ans;
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
