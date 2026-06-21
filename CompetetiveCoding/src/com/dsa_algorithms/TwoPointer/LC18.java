package com.dsa_algorithms.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        long tar = target;

        int i = 0, j, k, l, n = nums.length;
        Arrays.sort(nums);

        while(i < n-3){
            j = i+1;
            while(j < n){
                k = j+1;
                l = n-1;
                while(k < l){
                    if (nums[k] + nums[l] < tar - (nums[i] + nums[j])){
                        k++;
                    } else if (nums[k] + nums[l] > tar - (nums[i] + nums[j])){
                        l--;
                    } else{
                        ans.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        k = nextIndex(++k, l, -1, nums);
                        l = nextIndex(--l, n, 1, nums);
                    }
                }
                j = nextIndex(++j, n, -1, nums);
            }
            i = nextIndex(++i, n, -1, nums);
        }
        return ans;
    }
    private int nextIndex(int i, int n, int counter, int[] nums){
        while(i > 0 && i < n && nums[i] == nums[i+counter]){
            i += -1*counter;
        }
        return i;
    }
}
