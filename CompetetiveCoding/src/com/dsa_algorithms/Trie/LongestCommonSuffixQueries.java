package com.dsa_algorithms.Trie;

class Trie{
    Trie[] chars;
    int ind;
    Trie(){
        this.chars = new Trie[26];
        this.ind = -1;
    }
    public static void insert(Trie trie, String word, String[] words, int i){
        Trie head = trie;
        word = new StringBuilder(word).reverse().toString();

        for(char ch:word.toCharArray()){
            int j = (ch-'a');
            if (head.chars[j] == null)
                head.chars[j] = new Trie();
            head = head.chars[j];
            if (head.ind == -1 || word.length() < words[head.ind].length())
                head.ind = i;
        }
    }

    public static int findSuffix(Trie trie, String word){
        word = new StringBuilder(word).reverse().toString();
        for(char ch:word.toCharArray()){
            int i = ch-'a';
            if (trie.chars[i] != null)
                trie = trie.chars[i];
            else
                break;
        }
        return trie.ind;
    }
}

public class LongestCommonSuffixQueries {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int i=0, m = wordsContainer.length, n = wordsQuery.length, mini = 0;
        int[] ans = new int[n];
        Trie trie = new Trie();
        for(String word:wordsContainer){
            Trie.insert(trie, word, wordsContainer, i++);
            if (word.length() < wordsContainer[mini].length())
                mini = i-1;
        }
        trie.ind = mini;
        i = 0;
        for(String word:wordsQuery){
            ans[i++] = Trie.findSuffix(trie, word);
        }
        return ans;
    }
}
