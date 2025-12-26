package com.dsa_algorithms.Graph.BFS;

import java.util.*;

public class LC433 {
    static class Node{
        String value;
        int steps;
        public Node(String value, int steps){
            this.value = value;
            this.steps = steps;
        }
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)){
            return 0;
        }
        int i;
        Set<String> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        char[] genes = new char[]{'A', 'C', 'G', 'T'};

        Collections.addAll(set, bank);
        if (!set.contains(endGene)){
            return -1;
        }
        queue.offer(new Node(startGene, 0));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            char[] value = node.value.toCharArray();
            for(i=0; i<8; i++){
                char ch = value[i];
                for(char gene:genes){
                    value[i] = gene;
                    String key = new String(value);
                    if (key.equals(endGene)){
                        return node.steps+1;
                    }
                    if (set.remove(key)){
                        queue.offer(new Node(key, node.steps+1));
                    }
                }
                value[i] = ch;
            }
        }
        return -1;
    }
}
