package com.dsa_algorithms.Graph.DFS_BFS;

public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int i, n = nums.length, len, ans = 0;

        for(i=0; i<n; i++){
            int j = i;
            len = 0;
            while(nums[j] != Integer.MAX_VALUE){
                int temp = j;
                j = nums[j];
                nums[temp] = Integer.MAX_VALUE;
                len++;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}
