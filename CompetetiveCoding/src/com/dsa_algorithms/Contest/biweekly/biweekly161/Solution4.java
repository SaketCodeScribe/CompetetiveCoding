package com.dsa_algorithms.Contest.biweekly.biweekly161;

public class Solution4 {
    public long popcountDepth(long n, int k) {
        String binary = findLength(n);
        int i, len = binary.length();
        long ans = 0;
        long[] dp = new long[64];

        for(i=2; i<=64; i++){
            dp[i] = dp[Integer.bitCount(i)]+1;
            if (dp[i] == k && i <= dp.length){
                ans++;
            }
            // 1 0 0 0 1 0 1 0 1 0 1 0 1
            if (dp[i] == k-1){
                if (Math.pow(2,i) > 64) {
                    int id = i, j = -1;
                    while(id < len){
                        ans += computation(id-1, i-1);
                        if (binary.charAt(len-id) == '1'){
                            j = id-1;
                        }
                        id++;
                    }
                    if (j >= i-1){
                        ans += computation(j, i-1);
                    }
                }
            }
        }
        return ans;
    }

    private String findLength(long n) {
        int len = 0;
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n%2);
            n /= 2;
            len++;
        }
        return sb.toString();
    }

    private long computation(int n, int k) {
        if (k > n){
            return 0;
        }
        if (n == 0 || k == 0){
            return 1;
        }
        double val = 1;

        for(int i=0; i<Math.min(k, n-k); i++){
            val *= (n-i)/(1.0*(i+1));
        }
        return (long)val;
    }

    public static void main(String[] args) {
        Solution4 obj = new Solution4();
        System.out.println(obj.popcountDepth(5457, 4));
    }
}
