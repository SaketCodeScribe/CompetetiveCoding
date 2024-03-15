package com.dsa_algorithms.String;

import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        List<Node> node = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(char ch:s.toCharArray())
            map.put(ch, map.getOrDefault(ch,0)+1);
        for(Map.Entry<Character, Integer> entry:map.entrySet()){
            node.add(new Node(entry.getKey(), entry.getValue()));
        }
        Collections.sort(node, (a, b) -> (b.val-a.val));
        StringBuilder ans = new StringBuilder();
        for(Node n:node)
            while(n.val-- > 0)
                ans.append(n.data);
        return ans.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency obj = new SortCharactersByFrequency();
        System.out.println(obj.frequencySort("tree"));
        System.out.println(obj.frequencySort("cccaaa"));
        System.out.println(obj.frequencySort("ivoieoirjfncsdcknqeiwfoejrfnvjkcvhasiuwq"));
    }
}
class Node{
    char data;
    int val = 0;
    public Node(char data, int val){
        this.data = data;
        this.val = val;
    }
}