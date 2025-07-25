package com.dsa_algorithms.practice;

import java.util.Stack;

public class L1504 {
    public int numSubmat(int[][] mat) {
        int i, j, m = mat.length, n = mat[0].length, ans = 0;
        int[] hist = new int[n];

        for(i=0; i<m; i++){
            for(j=0; j<n; j++){
                if (mat[i][j] == 1){
                    hist[j]++;
                }
                else{
                    hist[j] = 0;
                }
            }
            ans += numSubmat(hist, n);
        }
        return ans;
    }
    private int numSubmat(int[] hist, int n){
        int i, cnt = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(i=0; i<n; i++){
            while(stack.size() > 1 && hist[stack.peek()] < hist[i]){
                int curr = stack.pop();
                int prev = curr - stack.peek();
                cnt += (i-curr)*hist[curr]+prev*hist[curr];
            }
            stack.push(i);
        }
        return cnt;
    }
}
