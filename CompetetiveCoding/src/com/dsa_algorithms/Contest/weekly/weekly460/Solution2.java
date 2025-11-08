package com.dsa_algorithms.Contest.weekly.weekly460;

public class Solution2 {
    public long numOfSubsequences(String s) {
        int i, n = s.length();
        long c = 0, t = 0;
        int[] lCnt = new int[n];
        long cnt = 0, ans = 0, original = 0, maxUpto = 0;
        lCnt[0] = s.charAt(0) == 'L' ? 1 : 0;
        for(i=1; i<n; i++){
            lCnt[i] = lCnt[i-1];
            if(s.charAt(i) == 'L'){
                lCnt[i]++;
            }
        }

        for(i=n-1; i>=0; i--){
            char ch = s.charAt(i);
            if (ch == 'T'){
                original += t*c*lCnt[i];
                c = 0;
                t++;
            }
            else if (ch == 'C'){
                c++;
                long max = Math.max((c+1)*t, c*(t+1));
                max = Math.max(max*lCnt[i], (lCnt[i]+1)*c*t);
                long temp = maxUpto;
                ans = Math.max(ans, original+max);
                ans = Math.max(ans,temp+c*t*lCnt[i]);
            }
            System.out.println(ans +" "+cnt+" "+original);
        }
        return ans;
    }
}
