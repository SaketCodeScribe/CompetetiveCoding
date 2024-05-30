package com.dsa_algorithms.Graph;

import java.util.*;

public class SnakeAndLadder {
    static class Coordinate{
        int row, col;
        public Coordinate(int cell, int n){
            this.row = (cell-1)/n;
            this.col = (cell-1)%n;
            if (this.row % 2 == 1)
                this.col = n-1-this.col;
            this.row = n-1-this.row;
        }
    }

    public static int minDiceThrowToLastCell(int[][] board) {
        //Your code goes here
        int i, j, n = board.length, cnt = 0, ans = 0;
        boolean[] vis = new boolean[n*n+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        vis[1] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int node = queue.poll();
                if (node == n*n)
                    return ans;
                for(i=1; i<=6; i++){
                    if (node+i <= n*n){
                        Coordinate cord = new Coordinate(node+i, n);
                        int val = board[cord.row][cord.col] == -1 ? node+i : board[cord.row][cord.col];
                        if (!vis[val]){
                            queue.add(val);
                            vis[val] = true;
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
