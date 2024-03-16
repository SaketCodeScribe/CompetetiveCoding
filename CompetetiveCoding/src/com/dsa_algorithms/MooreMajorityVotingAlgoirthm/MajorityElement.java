package com.dsa_algorithms.MooreMajorityVotingAlgoirthm;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int i = 0, cnt = 0, ans = nums[0], n = nums.length;

        while (i<n){
            if (cnt == 0){
                cnt = 1;
                ans = nums[i];
            }
            else if (ans == nums[i]){
                cnt++;
            }
            else
                cnt--;
            i++;
        }
        cnt = 0;
        for(int num:nums){
            if (num == ans)
                cnt++;
        }
        return cnt > n/2 ? ans : -1;
    }
}
