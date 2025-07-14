package com.dsa_algorithms.Interview;

import java.util.*;
/*
we have a dictionary of words and a function which gives hash of these words and another function
which gives score=sum of diff of adjacent characters in a string and implement another function
which gives the anagram of the given word with highest score.
Hash of all anagrams is same.

`class Solution
{
public:
vectorwords={"cat","tac","dog","god","cow"}; //given
string getHash(string word);//some hidden implementation =O(1)
int getScore(string word) // sum of diff of adjacent characters in a string=O(len(word))
 */
public class Solution5 {
    static class Pair{
        String str;
        int score;

        public Pair(String str, int score) {
            this.str = str;
            this.score = score;
        }
    }
    Map<Integer, Pair> map = new HashMap<>();
    Solution5(String[] arr){
        int i = 0;
        for(String str:arr) {
            int hash = getHash(str);
            int score = getSum(str);
            map.putIfAbsent(hash, new Pair(str, score));
            Pair pair = map.get(hash);
            if (score > pair.score){
                map.put(hash, new Pair(str, score));
            }
            else if (score == pair.score && str.compareTo(pair.str) < 0){
                map.put(hash, new Pair(str, score));
            }
        }
    }

    private int getHash(String word){
        return word.hashCode();
    }
    private int getSum(String word){
        return word.length();
    }
    private String getBestAnagram(String word){
        int hash = getHash(word);
        if (!map.containsKey(hash)){
            return "";
        }
        return map.get(hash).str;
    }
}
