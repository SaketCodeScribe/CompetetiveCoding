package com.dsa_algorithms.Contest.biweekly.biweekly160;

import java.util.*;
public class Solution1 {

    public static String concatHex36(int n) {
        return getDecimal(n*n, 16)+getDecimal(n*n*n, 36);
    }

    private static String getDecimal(int num, int dec) {
        StringBuilder sb = new StringBuilder();

        while(num > 0){
            int rem = num%dec;
            if (rem < 10){
                sb.append(rem);
            }
            else{
                sb.append((char)('A'+rem-10));
            }
            num /= dec;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(concatHex36(13));
    }
}
