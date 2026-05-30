package com.dsa_algorithms.BinarySearch.Maximize_or_minimize_to_achieve_target;

import java.util.Stack;

public class LC3510 {
    public static void main(String[] args) {
        LC3510 lc3510 = new LC3510();
        System.out.println(lc3510.minimumPairRemoval(new int[]{1,2,2}));
    }
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length, low = 0, mid, high = n - 1, operations = 0;

        while(low <= high){
            mid = low + ((high - low) >> 1);

            if (noOfOperations(nums, n) <= mid){
                operations = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return operations;
    }

    private int noOfOperations(int[] nums, int n){
        int operations = 0, i;
        Stack<Long> stack = new Stack<>();

        for(i=n-1; i>=0; i--){
            while(stack.size() > 1 && stack.peek() < nums[i]){
                stack.push(stack.pop() + stack.pop());
                operations++;
            }
            if (!stack.isEmpty() && stack.peek() < nums[i]){
                stack.push(stack.pop() + nums[i]);
                operations++;
            }
            else{
                stack.push((long)nums[i]);
            }
        }
        return operations;
    }
}
