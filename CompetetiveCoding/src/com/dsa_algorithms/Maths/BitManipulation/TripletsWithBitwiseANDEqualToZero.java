package com.dsa_algorithms.Maths.BitManipulation;

public class TripletsWithBitwiseANDEqualToZero {
    public int countTriplets(int[] nums) {
        int i, ans = 0, max = 0, n = 1;
        for(int num:nums)
            max = Math.max(max, num);
        while(n < max)
            n = n<<1;
        int[] cnt = new int[n+1];

        for(int a:nums){
            for(int b:nums)
                cnt[a&b]++;
        }
        for(int a:nums){
            for(i=0; i<=n; i++)
                if((a&i) == 0)
                    ans += cnt[i];
        }
        return ans;
    }
    // Dp
    public int countTriplets1(int[] A) {
        int N = 1 << 16, M = 3;
        int[][] dp = new int[M + 1][N];
        dp[0][N - 1] = 1;
        for (int i = 0; i < M; i++) {
            for (int k = 0; k < N; k++) {
                for (int a : A) {
                    dp[i + 1][k & a] += dp[i][k];
                }
            }
        }
        return dp[M][0];
    }
}
