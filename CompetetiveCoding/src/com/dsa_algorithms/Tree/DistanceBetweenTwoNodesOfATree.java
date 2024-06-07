package com.dsa_algorithms.Tree;

public class DistanceBetweenTwoNodesOfATree {
    static 	class TreeNode    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val)
        {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    static int ans = -1;
    public static int findDistanceBetweenNodes(TreeNode root, int node1, int node2)
    {
        ans = -1;
        findDist(root, node1, node2);
        return ans;
    }
    static int findDist(TreeNode root, int node1, int node2){
        if (root == null)
            return 0;
        int ld = findDist(root.left, node1, node2);
        int rd = findDist(root.right, node1, node2);
        if ((root.val == node1 && root.val == node2) || ((root.val == node1 || root.val == node2) && ld+rd > 0) || (ld > 0 && rd > 0))
            return ans = ld+rd;
        if (root.val == node1 || root.val == node2)
            return 1;
        return ld+rd > 0 ? ld+rd+1 : ld+rd;
    }
}
