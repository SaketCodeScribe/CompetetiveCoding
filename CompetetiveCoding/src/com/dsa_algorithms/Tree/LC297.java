package com.dsa_algorithms.Tree;

public class LC297 {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.toString();
    }

    private void encode(TreeNode node, StringBuilder sb) {
        if (node == null) { sb.append("#,"); return; }
        sb.append(node.val).append(',');
        encode(node.left, sb);
        encode(node.right, sb);
    }


    public TreeNode deserialize(String data) {
        return decode(data, new int[]{0});
    }

    private TreeNode decode(String data, int[] pos) {
        if (data.charAt(pos[0]) == '#') { pos[0] += 2; return null; }
        int sign = 1, num = 0;
        if (data.charAt(pos[0]) == '-') { sign = -1; pos[0]++; }
        while (data.charAt(pos[0]) != ',') num = num * 10 + data.charAt(pos[0]++) - '0';
        pos[0]++;
        TreeNode node = new TreeNode(sign * num);
        node.left = decode(data, pos);
        node.right = decode(data, pos);
        return node;
    }
}
