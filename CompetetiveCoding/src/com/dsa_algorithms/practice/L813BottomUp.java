package com.dsa_algorithms.practice;

public class L813BottomUp {
        public double largestSumOfAverages(int[] nums, int k) {
            int i, j, p, n = nums.length;
            double[] prefixSum = new double[n+1];
            double[][] dp = new double[n+1][k+1];

            for(i=1; i<=n; i++){
                prefixSum[i] = prefixSum[i-1]+nums[i-1];
            }

            for(p=0; p<=k; p++){
                for(i=1; i<=n; i++){
                    if (p == 0){
                        dp[i][p] = Double.MIN_VALUE;
                        continue;
                    }
                    for(j=i; j>0; j--){
                        double avg = (prefixSum[i]-prefixSum[j-1]) / (i-j+1);
                        if (p == 1){
                            dp[i][p] = avg;
                        }
                        else{
                            dp[i][p] = Math.max(dp[i][p], dp[j-1][p-1] + avg);
                        }
                    }
                }
            }

            return dp[n][k];
        }

        private double getMaxScore(double[] prefixSum, int n, int i, int k, Double[][] dp) {
            if (i > n && k == 0){
                return 0;
            }
            if (i > n || k == 0){
                return Integer.MIN_VALUE;
            }
            if (dp[i][k] != null){
                return dp[i][k];
            }
            double maxScore = 0;
            for(int j=i; j<=n; j++){
                maxScore = Math.max(maxScore, getMaxScore(prefixSum, n, j+1, k-1, dp) + (prefixSum[j]-prefixSum[i-1])/(j-i+1));
            }
            return dp[i][k] = maxScore;
        }
}
