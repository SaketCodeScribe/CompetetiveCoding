package com.dsa_algorithms.DynamicProgramming;

public class CountAlternatingSubarrays {
    /*
        O(N) space solution
     */
    public long countAlternatingSubarrays(long[] nums) {
            int i, n = nums.length;
            long ans = 0;
            long[] dp = new long[n];

            for(i=0; i<n; i++){
                dp[i] = 1;
                if (i > 0 && nums[i]+nums[i-1] == 1)
                    dp[i] = dp[i-1]+1;
                ans += dp[i];
            }
            return ans;
    }
    /*
        Above dp solution can be reduced to O(1) space solution
     */
    public long countAlternatingSubarrays(int[] nums) {
        int i, n = nums.length;
        long ans = 0, curr = 0;

        for(i=0; i<n; i++){
            curr = i > 0 && nums[i]+nums[i-1] == 1 ? ++curr : 1;
            ans += curr;
        }
        return ans;
    }
}
