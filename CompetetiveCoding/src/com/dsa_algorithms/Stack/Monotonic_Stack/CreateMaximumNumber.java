package com.dsa_algorithms.Stack.Monotonic_Stack;

import java.util.*;

/*
    Here in merging, I'd to call greater method to decide for the next pointer. The reason can be understood from:
    a - 7 6 3
    b - 9 3 6
    if the pointer a is at digit 3, and b is also at digit 3. then which should I increment, if I inc a then the resulting
    ans would look like 336, but if I inc b then the resulting ans would look like 363. Hence, for two pointers
    having equal digits, we need to check the next different ele which is larger, and consider that pointer to inc.s
 */
public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int i, j, m = nums1.length, n = nums2.length;
        List<Integer> stack1, stack2;
        int[] ans = new int[k], temp;

        for(i=0; i<=k; i++){
            j = k-i;
            if (i > m || j > n)
                continue;
            stack1 = maxNumberUsingOneArray(nums1, i);
            stack2 = maxNumberUsingOneArray(nums2, j);

            int p = 0, q = 0, id = 0;
            temp = new int[k];
            while(p < i || q < j){
                if (q >= j || (p < i && findGreaterElement(stack1, stack2, p, q)))
                    temp[id++] = stack1.get(p++);
                else
                    temp[id++] = stack2.get(q++);
            }
            if(findGreater(temp, ans))
                ans = temp;
        }
        return ans;
    }
    public List<Integer> maxNumberUsingOneArray(int[] nums, int k){
        int i, n = nums.length;
        Stack<Integer> stack = new Stack<>();

        for(i=0; i<n; i++){
            while(!stack.isEmpty() && stack.peek() < nums[i] && k-stack.size() <= n-i-1)
                stack.pop();
            if (stack.size() < k)
                stack.push(nums[i]);
        }
        return stack;
    }
    public boolean findGreaterElement(List<Integer> nums1, List<Integer> nums2, int i, int j){
        int m = nums1.size(), n = nums2.size();

        while(i < m || j < n){
            if (i >= m)
                return false;
            if (j >= n)
                return true;
            if (nums1.get(i) > nums2.get(j))
                return true;
            else if (nums1.get(i) < nums2.get(j))
                return false;
            i++; j++;
        }
        return true;
    }
    public boolean findGreater(int[] nums1, int[] nums2){
        int i = 0, n = nums1.length;
        if (nums2.length == 0)
            return true;

        while(i < n){
            if (nums1[i] > nums2[i])
                return true;
            else if (nums1[i] < nums2[i])
                return false;
            i++;
        }
        return false;
    }
}