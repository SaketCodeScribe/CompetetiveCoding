package com.dsa_algorithms.Graph;
import java.util.*;
public class Manager {
    private int ans = 0;
    static class Node{
        List<Node> childNodes;
        int salary;
    }
    public void main(String[] args){

    }

    private int countDiscrimination(Node root){
        postOrderTraversal(root);
        return ans;
    }
    private int[] postOrderTraversal(Node root){
        if (root == null){
            return new int[]{0,0};
        }
        double salaries = 0, noOfChilds = 0;
        for(Node child:root.childNodes){
            int[] resultOfChilds = postOrderTraversal(child);
            salaries += resultOfChilds[0];
            noOfChilds += resultOfChilds[1];
        }
        int diffInSalary = 0;
        if (salaries/noOfChilds > root.salary){
            diffInSalary = (int)Math.ceil(salaries/noOfChilds-root.salary);
        }
        return new int[]{root.salary+diffInSalary+(int)salaries, (int)noOfChilds+1};
    }
}
