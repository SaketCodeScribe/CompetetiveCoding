package com.dsa_algorithms.SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LC3321 {

    static class Node implements Comparable<Node> {
        long value, freq;

        public Node(long v) {
            value = v;
            freq = 1L;
        }

        public int compare(Node other) {
            int freqComp = Long.compare(other.freq, this.freq);
            return freqComp != 0 ? freqComp : Long.compare(other.value, this.value);
        }

        @Override
        public int compareTo(Node other) {
            return compare(other);
        }

        @Override
        public int hashCode() {
            return Long.hashCode(value);
        }

        @Override
        public boolean equals(Object other) {
            return Long.compare(this.value, ((Node) other).value) == 0;
        }

        @Override
        public String toString() {
            return "value: " + value + ", freq: " + freq;
        }
    }

    public long[] findXSum(int[] nums, int k, int x) {
        int i, n = nums.length, ind = 0;

        TreeMap<Node, Node> minTree = new TreeMap<>((a, b) -> {
            int freqComp = Long.compare(a.freq, b.freq);
            return freqComp != 0 ? freqComp : Long.compare(a.value, b.value);
        });

        TreeMap<Node, Node> maxTree = new TreeMap<>((a, b) -> {
            int freqComp = Long.compare(b.freq, a.freq);
            return freqComp != 0 ? freqComp : Long.compare(b.value, a.value);
        });

        Map<Long, Node> map = new HashMap<>();

        long[] ans = new long[n - k + 1];
        long window = 0;

        for (i = 0; i < n; i++) {
            Node node = new Node(nums[i]);
            if (i >= k) {
                ans[ind++] = window;
                window += remove(minTree, maxTree, map, nums[i-k]);
            }
            window += add(minTree, maxTree, map, nums[i]);
            window += rebalanceTree(minTree, maxTree, x);
        }

        ans[ind] = window;
        return ans;
    }

    private long add(TreeMap<Node, Node> minTree, TreeMap<Node, Node> maxTree, Map<Long, Node> map, long element) {
        map.computeIfAbsent(element, x -> new Node(x));
        Node node = map.get(element);

        long net = 0;

        if (minTree.containsKey(node)) {
            node = minTree.get(node);
            minTree.remove(node);
            node.freq++;
            minTree.put(node, node);
            net += node.value;
        } else {
            if (maxTree.containsKey(node)) {
                node = maxTree.get(node);
                maxTree.remove(node);
                node.freq++;
            }
            maxTree.put(node, node);
        }

        return net;
    }

    private long remove(TreeMap<Node, Node> minTree, TreeMap<Node, Node> maxTree, Map<Long, Node> map, long element) {
        Node node = map.getOrDefault(element, new Node(element));
        long net = 0;

        if (maxTree.containsKey(node)) {
            node = maxTree.get(node);
            maxTree.remove(node);

            if (node.freq > 1) {
                node.freq--;
                maxTree.put(node, node);
            } else {
                map.remove(node.value);
            }
        } else {
            node = minTree.get(node);
            net -= node.value;
            minTree.remove(node);

            if (node.freq > 1) {
                node.freq--;
                minTree.put(node, node);
            } else {
                map.remove(node.value);
            }
        }

        return net;
    }

    private long rebalanceTree(TreeMap<Node, Node> minTree, TreeMap<Node, Node> maxTree, int size) {
        if (maxTree.isEmpty()) return 0;

        Node left, right;
        long net = 0;

        if (minTree.size() < size) {
            left = maxTree.firstKey();
            maxTree.remove(left);
            minTree.put(left, left);
            net += left.value * left.freq;
        } else {
            left = maxTree.firstKey();
            right = minTree.firstKey();

            if (left.compareTo(right) < 0) {
                maxTree.remove(left);
                minTree.remove(right);
                maxTree.put(right, right);
                minTree.put(left, left);
                net += left.value * left.freq - right.value * right.freq;
            }
        }

        return net;
    }
}
