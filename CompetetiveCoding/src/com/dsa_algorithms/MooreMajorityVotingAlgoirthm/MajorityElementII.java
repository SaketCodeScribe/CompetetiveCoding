package com.dsa_algorithms.MooreMajorityVotingAlgoirthm;

import java.util.*;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int i = 0, j = 0, n = nums.length, e1 = -1, cnt1 = 0, e2 = -1, cnt2 = 0;

        while (i < n){
            if (e1 == nums[i])
                cnt1++;
            else if (e2 == nums[i])
                cnt2++;
            else if (cnt1 == 0){
                e1 = nums[i];
                cnt1 = 1;
            }
            else if (cnt2 == 0){
                e2 = nums[i];
                cnt2 = 1;
            }
            else {
                cnt1--;
                cnt2--;
            }
            i++;
        }
        cnt1 = cnt2 = 0;
        for(i=0; i<n; i++){
            if (e1 == nums[i])
                cnt1++;
            else if (e2 == nums[i])
                cnt2++;
        }
        if (cnt1 > n/3 && cnt2 > n/3)
            return Arrays.asList(e1, e2);
        if (cnt1 > n/3)
            return Arrays.asList(e1);
        return cnt2 > n/3 ? Arrays.asList(e2) : Arrays.asList();
    }
}
