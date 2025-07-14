package com.dsa_algorithms.Interview;

import java.util.*;

public class Solution2 {
    static class Tree{
        int val;
        Tree left, right;
    }
    static class Result{
        int val;
    }
    public int countIsland(Tree root){
        Result ans = new Result();
        if (isIsland(root, ans)){
            ans.val++;
        }
        return ans.val;
    }

    private boolean isIsland(Tree node, Result ans) {
        if (node == null){
            return false;
        }
        boolean left = isIsland(node.left, ans);
        boolean right = isIsland(node.right, ans);
        if (node.val == 1){
            return true;
        }
        if (left){
            ans.val++;
        }
        if (right){
            ans.val++;
        }
        return false;
    }
    public Set<Integer> sizeOfIsland(Tree root){
        Set<Integer> islands = new HashSet<>();
        int sizeOfIslandStartingFromRoot = islandSize(root, islands);
        if (sizeOfIslandStartingFromRoot > 0){
            islands.add(sizeOfIslandStartingFromRoot);
        }
        return islands;
    }
    private int islandSize(Tree node, Set<Integer> islands){
        if (node == null){
            return 0;
        }
        int left = islandSize(node.left, islands);
        int right = islandSize(node.right, islands);
        if (node.val == 1){
            return left+right+1;
        }
        if (left > 0){
            islands.add(left);
        }
        if (right > 0){
            islands.add(right);
        }
        return 0;
    }

}
