package com.dsa_algorithms.SlidingWindow;

public class ShortestSubarrayWithORatLeastKII {
    public int minimumSubarrayLength(int[] nums, int k) {
        int val = -1, start=0, end=0, n = nums.length, ans = Integer.MAX_VALUE;
        int[] bits = new int[32];
        while(end < n){
            while(end < n && val < k){
                if (val == -1)
                    val = 0;
                countBits(bits, nums[end++], -1);
                val = calculateVal(bits);
            }
            while(start < end && val >= k){
                ans = Math.min(ans, end-start);
                countBits(bits, nums[start], 1);
                val = calculateVal(bits);
                start++;
            }
            if (val == 0)
                val = -1;
        }
        return ans < Integer.MAX_VALUE ? ans : -1;
    }
    public void countBits(int[] bits, int num, int remove){
        for(int i=0; i<32; i++){
            if ((num & (1<<i)) > 0){
                if (remove == -1)
                    bits[i]++;
                else
                    bits[i]--;
            }
        }
    }
    public int calculateVal(int[] bits){
        int val = 0;
        for(int i=0; i<32; i++){
            val = bits[i] > 0 ? val+(1<<i) : val;
        }
        return val;
    }
}
