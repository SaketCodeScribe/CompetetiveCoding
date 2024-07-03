package com.dsa_algorithms.Maths;

import java.util.*;
import java.util.stream.Collectors;

public class FractionToRecurring {
    public String fractionToDecimal(int numerator, int denominator) {
        List<String> ans = new ArrayList<>();
        Map<Long, Integer> map = new HashMap<>();
        char sign = ' ';
        long a = numerator, b = denominator;
        int i = 0;
        boolean isDecimal = false;

        if (a == 0)
            return "0";
        if (a == Integer.MIN_VALUE && b == -1)
            return "2147483648";
        if ((a < 0 && b > 0) || (a > 0 && b < 0))
            sign = '-';
        a = Math.abs(a); b = Math.abs(b);
        System.out.println(a+" "+b);
        while(a != 0){
            long rem = a%b;
            ans.add(String.valueOf(a/b));
            if (map.containsKey(rem)){
                a = rem;
                break;
            }
            map.put(rem, i++);
            if (rem < b && rem > 0){
                if (ans.size() == 1)
                    ans.add(".");
                rem *= 10;
            }
            a = rem;
        }
        System.out.println(a);
        if (a != 0){
            int j = map.get(a);
            ans.add(ans.size()-i+j,  "(");
            ans.add(")");
        }
        if (sign == '-')
            ans.add(0, "-");
        return ans.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
