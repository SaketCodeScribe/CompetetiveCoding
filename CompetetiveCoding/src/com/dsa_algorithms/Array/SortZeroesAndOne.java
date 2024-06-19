package com.dsa_algorithms.Array;

public class SortZeroesAndOne {
    public static void sortZeroesAndOne(int[] arr) {
        //Your code goes here
        int i = 0, j = 0, n = arr.length;

        while(i < n){
            if (arr[i] == 0){
                if (arr[j] == 1)
                    arr[i] = 1;
                arr[j++] = 0;
            }
            i++;
        }
    }
}
