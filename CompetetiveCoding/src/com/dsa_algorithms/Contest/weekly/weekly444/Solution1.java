package com.dsa_algorithms.Contest.weekly.weekly444;

import java.util.*;
import java.util.stream.Collectors;

public class Solution1 {
    public static int minimumPairRemoval(int[] nums) {
        int i, n = nums.length, ans = 0;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        while (list.size() > 1) {
            int minSum = 3000, mi = -1;
            boolean flag = true;
            for (i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i+1)){
                    flag = false;
                }
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    mi = i;
                }
            }
            if (mi == -1 || flag) {
                return ans;
            }
            list.set(mi, minSum);
            list.remove(mi + 1);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumPairRemoval(new int[]{-7,-2,-4,4,8,-6,0,0,4,5,1,-8}));
    }
}
