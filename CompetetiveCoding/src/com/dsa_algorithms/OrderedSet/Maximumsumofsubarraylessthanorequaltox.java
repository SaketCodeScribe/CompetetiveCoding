package com.dsa_algorithms.OrderedSet;

import java.util.TreeSet;

public class Maximumsumofsubarraylessthanorequaltox {
    long findMaxSubarraySum(long arr[], int n,int x)
    {
        int i;
        long sum = 0, max = Integer.MIN_VALUE;
        TreeSet<Long> tree = new TreeSet<>();
        tree.add(0l);
        for(i=0; i<n; i++){
            sum += arr[i];
            Long val = tree.ceiling(sum-x);
            if (val != null)
                max = Math.max(max, sum-val);
            tree.add(sum);
        }
        return max > Integer.MIN_VALUE ? max : 0;
    }
}
