package com.dsa_algorithms.String.Simulation;

import java.util.*;
import java.util.stream.Collectors;

public class IntegerToEnglishWords {
    Map<Integer, String> numberMap;
    {
        numberMap = new HashMap<>();
        numberMap.put(1, "One");
        numberMap.put(2, "Two");
        numberMap.put(3, "Three");
        numberMap.put(4, "Four");
        numberMap.put(5, "Five");
        numberMap.put(6, "Six");
        numberMap.put(7, "Seven");
        numberMap.put(8, "Eight");
        numberMap.put(9, "Nine");
        numberMap.put(10, "Ten");
        numberMap.put(11, "Eleven");
        numberMap.put(12, "Twelve");
        numberMap.put(13, "Thirteen");
        numberMap.put(14, "Fourteen");
        numberMap.put(15, "Fifteen");
        numberMap.put(16, "Sixteen");
        numberMap.put(17, "Seventeen");
        numberMap.put(18, "Eighteen");
        numberMap.put(19, "Nineteen");
        numberMap.put(20, "Twenty");
        numberMap.put(30, "Thirty");
        numberMap.put(40, "Forty");
        numberMap.put(50, "Fifty");
        numberMap.put(60, "Sixty");
        numberMap.put(70, "Seventy");
        numberMap.put(80, "Eighty");
        numberMap.put(90, "Ninety");
    }
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        String[] temp = new String[]{"", "Thousand", "Million", "Billion", "Trillion"};
        List<String> list = new ArrayList<>();
        String str = String.valueOf(num);

        int i, n = str.length(), cnt = 0;
        i = n-1;

        while(i >= 0){
            while ((str.charAt(i)-'0') == 0){
                cnt++;
                i--;
            }
            int val = str.charAt(i)-'0';
            if ((i+1 < n && (str.charAt(i+1)-'0') == 0) || cnt%3 == 0){
                if (cnt%3 == 2 && i+2 < n && (str.charAt(i+2)-'0') == 0 && cnt/3 > 0)
                    list.add(temp[cnt/3]);
                else if (cnt%3 < 2 && cnt/3 > 0)
                    list.add(temp[cnt/3]);
            }
            if (cnt%3 == 1){
                val = val*10;
                if (val == 10 && i+1 < n && (str.charAt(i+1)-'0') > 0){
                    list.remove(list.size()-1);
                    val += (i+1 < n ? str.charAt(i+1)-'0' : 0);
                }
                list.add(numberMap.get(val));
            }
            else if (cnt%3 == 2){
                list.add("Hundred");
                list.add(numberMap.get(val));
            }
            else
                list.add(numberMap.get(val));
            cnt++;
            i--;
        }
        Collections.reverse(list);
        return list.stream().collect(Collectors.joining(" "));
    }
}
