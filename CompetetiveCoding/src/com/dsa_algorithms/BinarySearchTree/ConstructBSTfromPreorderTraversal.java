package com.dsa_algorithms.BinarySearchTree;


public class ConstructBSTfromPreorderTraversal {
     static class TreeNode
     {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode(int data) {
             this.val = data;
             left = null;
             right = null;
         }
     }
    int n;
    public TreeNode bstFromPreorder(int[] preorder) {
        n = preorder.length;
        return bstFromPreOrder(0, n-1, preorder);
    }
    public TreeNode bstFromPreOrder(int l, int r, int[] preorder){
        if (l > r)
            return null;
        if (l == r)
            return new TreeNode(preorder[l]);
        TreeNode root = new TreeNode(preorder[l]);
        int i = l;
        for(i=l+1; i<=r; i++){
            if (preorder[l] < preorder[i]){
                break;
            }
        }
        if (i > r)
            root.left = bstFromPreOrder(l+1, r, preorder);
        else{
            root.left = bstFromPreOrder(l+1, i-1, preorder);
            root.right = bstFromPreOrder(i, r, preorder);
        }
        return root;
    }
}
