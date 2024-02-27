package com.dsa_algorithms.Trie;

class TrieNode {
    TrieNode[] node;
    boolean isEnd;

    public TrieNode(){
        node = new TrieNode[26];
        isEnd = false;
    }
}
class ImplementTrie {
    TrieNode trieNode;
    public ImplementTrie() {
        trieNode = new TrieNode();
    }

    public void insert(String word) {
        int n = word.length();
        TrieNode temp = this.trieNode;
        for(int i=0; i<n; i++){
            if (temp.node[word.charAt(i)-'a'] == null)
                temp.node[word.charAt(i)-'a'] = new TrieNode();
            temp = temp.node[word.charAt(i)-'a'];
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        int n = word.length();
        TrieNode temp = trieNode;
        for(int i=0; i<n; i++){
            if (temp.node[word.charAt(i)-'a'] == null)
                return false;
            temp = temp.node[word.charAt(i)-'a'];
        }
        return temp.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = trieNode;
        int n = prefix.length();
        for(int i=0; i<n; i++){
            if (temp.node[prefix.charAt(i)-'a'] == null)
                return false;
            temp = temp.node[prefix.charAt(i)-'a'];
        }
        return true;
    }
}
