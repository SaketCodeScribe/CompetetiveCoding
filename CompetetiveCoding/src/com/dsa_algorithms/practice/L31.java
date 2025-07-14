package com.dsa_algorithms.practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Collections.swap;

public class L31 {
    public static void main(String[] args) {

    }
    public void nextPermutation(int[] nums) {
        int i, n = nums.length;
        List<Integer> arr = Arrays.stream(nums).boxed().collect(Collectors.toList());

        Stack<Integer> stack = new Stack<>();
        int index = -1;
        boolean flag = false;

        for(i=n-1; i>=0 && !flag; i--){
            while(!stack.isEmpty() && arr.get(i) < arr.get(stack.peek())){
                index = stack.pop();

            }
            stack.push(i);
        }
        if (!flag){
            Collections.sort(arr);
        }
        else {
            Collections.swap(arr, index, i);
            Collections.sort(arr.subList(i + 1, arr.size()));
        }
        nums = arr.stream().mapToInt(val -> val).toArray();
    }
}
