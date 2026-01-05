package com.dsa_algorithms.DynamicProgramming.LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.List;

public class LC673 {
    static class Pair<K, V>{
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, i, j, count = 0;
        Pair<Integer, int[]> pair = lengthOfLIS(nums);
        int maxLis = pair.getKey();
        int[] lis = pair.getValue();
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(i=1; i<=n; i++){
            for(j=i-1; j>=0; j--){
                if ((j == 0 || nums[j-1] < nums[i-1]) && lis[i] == lis[j]+1){
                    dp[i] += dp[j];
                }
            }
            if (lis[i] == maxLis){
                count += dp[i];
            }
        }
        return count;
    }
    public Pair<Integer, int[]> lengthOfLIS(int[] nums) {
        int i, n = nums.length;
        List<Integer> list = new ArrayList<>();
        int[] lis = new int[n+1];

        for(i=0; i<n; i++){
            int j = ceil(list, nums[i]);
            if (j >= list.size()){
                list.add(nums[i]);
            }
            else{
                list.set(j, nums[i]);
            }
            lis[i+1] = j+1;
        }
        return new Pair<>(list.size(), lis);
    }
    private int ceil(List<Integer> list, int tar){
        int low = 0, high = list.size()-1, mid, ans = high+1;

        while(low <= high){
            mid = low + ((high - low)>>1);
            if (list.get(mid) >= tar){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}
