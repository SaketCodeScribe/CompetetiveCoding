package com.dsa_algorithms.Sorting;

import java.util.*;
import java.util.stream.*;

public class LargestNumber {
    static class sortByDigit implements Comparator<String>{
        @Override
        public int compare(String a, String b){
            String s1 = a+b;
            String s2 = b+a;
            return -1*s1.compareTo(s2);
        }
    }
    public String largestNumber(int[] nums) {
        for (int num:nums){
            if (num != 0){
                List<String> list = new ArrayList<>();
                IntStream.range(0, nums.length).forEach(i -> list.add(String.valueOf(nums[i])));
                Collections.sort(list, new sortByDigit());
                return list.stream().collect(Collectors.joining());
            }
        }
        return "0";
    }
}
