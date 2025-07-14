package com.dsa_algorithms.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Consider a social network with n users. You have been given vector<vector< int >> friends. where friends[i][0] and
friends[i][1] are friends. A person 'a' can view profile of 'b' if he is friend or has a indirect common friend.
Find out how many profiles can each user view.
Constraint :
n <= 10 ^ 5
friends.size() <= n
E.g. :
n = 7
friends = [{1,2}, {2,3}, {3,4}, {5,6}, {6,7}]
result = [4,4,4,4,3,3]

 */
public class SocialNw {
    int[] par, size;
    public List<Integer> getProfileView(int n, int[][] profiles){
        List<Integer> ans = new ArrayList<>();
        par = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);
        for(int i=0; i<n; i++){
            par[i] = i;
        }
        for(int[] profile:profiles){
            union(profile[0]-1, profile[1]-1);
        }
        for(int i=0; i<n; i++){
            int parent = findParent(i);
            ans.add(size[parent]);
        }
        return ans;
    }
    private int findParent(int node){
        if (node == par[node]){
            return node;
        }
        return par[node] = findParent(par[node]);
    }
    private void union(int a, int b){
        int parA = findParent(a), parB = findParent(b);
        if (parA == parB){
            return;
        }
        int sizeA = size[parA], sizeB = size[parB];

        if (sizeA < sizeB){
            par[parA] = parB;
            size[parB] = sizeA + sizeB;
        }
        else{
            par[parB] = parA;
            size[parA] = sizeA + sizeB;
        }
    }
}
