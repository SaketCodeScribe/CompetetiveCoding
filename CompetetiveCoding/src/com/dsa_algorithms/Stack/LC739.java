package com.dsa_algorithms.Stack;

public class LC739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int i, n = temperatures.length;
        int[] ans = new int[n];

        for(i=n-2; i>=0; i--){
            int next = i+1;
            while(ans[next] != 0 && temperatures[i] >= temperatures[next]){
                next += ans[next];
            }
            if (temperatures[i] < temperatures[next]) ans[i] = next - i;
        }
        return ans;
    }
}
