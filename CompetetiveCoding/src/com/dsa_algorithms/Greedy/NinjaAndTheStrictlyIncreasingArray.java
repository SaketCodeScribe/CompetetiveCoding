package com.dsa_algorithms.Greedy;

public class NinjaAndTheStrictlyIncreasingArray {
    static int minimumMoves(int n, int []a) {
        // Write your code here.
        int i = 0, ans = Integer.MAX_VALUE;

        while(i<n){
            ans = Math.min(ans, leftMoves(0,i-1, a)+rightMoves(i+1, n-1, a));
            i++;
        }
        return ans;
    }
    static int leftMoves(int s, int e, int[] arr){
        int prev = 0, i = e, move = 0;

        while(i >= s){
            move += prev/arr[i]+1;
            prev = (prev/arr[i]+1)*arr[i--];
        }
        return move;
    }
    static int rightMoves(int s, int e, int[] arr){
        int prev = 0, i = s, move = 0;

        while(i <= e){
            move += prev/arr[i]+1;
            prev = (prev/arr[i]+1)*arr[i++];
        }
        return move;
    }
}
