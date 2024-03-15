package com.dsa_algorithms.Stack;

import java.util.Stack;

public class SumOfSubarrayMinimums {
    private static final int MOD = (int)Math.pow(10,9)+7;
    public int sumSubarrayMins(int[] arr) {
        int i = 0, n = arr.length, cnts = 0, cnt;
        long pre = 0, ans = 0;
        Stack<int[]> stack = new Stack<>();

        while (i < n){
            cnts = 1;
            while(!stack.isEmpty() && stack.peek()[0] > arr[i]){
                cnt = stack.peek()[1];
                pre = (pre-cnt*stack.pop()[0]+MOD)%MOD;
                cnts += cnt;
            }
            pre = (pre+cnts*arr[i])%MOD;
            ans = (ans+pre)%MOD;
            stack.push(new int[]{arr[i++], cnts});
        }
        return (int)ans;
    }
}
