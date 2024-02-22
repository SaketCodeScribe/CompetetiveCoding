package com.dsa_algorithms.Hash;

import java.util.*;

public class Countallsubarrayshavingsumdivisiblek {
    public static int subArrayCount(ArrayList< Integer > arr, int k) {
        int i, n = arr.size();
        long rem;
        long sum = 0, ans = 0;
        Map<Long, Long> map = new HashMap<>();
        map.put((long)0,(long)0);

        System.out.println(map);
        for(i=0; i<n; i++){
            sum += arr.get(i);
            rem = sum%k;
            if (rem < 0)
                rem += k;
            long count = map.getOrDefault(rem,(long)-1)+1;
            ans += count;
            map.put(rem, count);
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(subArrayCount(new ArrayList<>(Arrays.asList(5,0,-5,2,3,10,-5,-25,35,25)), 5));
    }

}
