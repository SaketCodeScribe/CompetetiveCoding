package com.dsa_algorithms.BackTracking;
import java.util.*;
import java.util.stream.Collectors;

public class LetterCombinations {
    static Map<Character, String> map = new HashMap<>();
    static{
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    static ArrayList<String> ans = new ArrayList<>();
    public static ArrayList<String> combinations(String s){
        // Write your code here

        ans = new ArrayList<>();
        getAllCombinations(new ArrayList<>(), 0, s);
        return ans;
    }
    static void getAllCombinations(List<Character> temp, int i, String s){
        if (i >= s.length()){
            ans.add(temp.stream().map(String::valueOf).collect(Collectors.joining("")));
            return;
        }
        for(char ch:map.get(s.charAt(i)).toCharArray()){
            temp.add(ch);
            getAllCombinations(temp, i+1, s);
            temp.remove(temp.size()-1);
        }
    }}
