package com.dsa_algorithms.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetermineRank {
    public boolean canDetermineRankForAnyOnePlayer(int[][] games, int n){
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[n];
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] game:games){
            adj.get(game[0]-1).add(game[1]-1);
            indegree[game[1]-1]++;
        }

        for(int i=0; i<n; i++){
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }
        if (queue.size() > 1){
            return false;
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int child:adj.get(node)){
                indegree[child]--;
                if (indegree[child] == 0){
                    queue.offer(child);
                }
            }
        }
        for(int i=0; i<n; i++){
            if (indegree[i] > 0){
                return false;
            }
        }
        return true;
    }

    public boolean canDetermineRankForPlayers(int[][] games, int n){
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[n];
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] game:games){
            adj.get(game[0]-1).add(game[1]-1);
            indegree[game[1]-1]++;
        }

        for(int i=0; i<n; i++){
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            if (queue.size() > 1){
                return false;
            }
            int node = queue.poll();
            for(int child:adj.get(node)){
                indegree[child]--;
                if (indegree[child] == 0){
                    queue.offer(child);
                }
            }
        }
        for(int i=0; i<n; i++){
            if (indegree[i] > 0){
                return false;
            }
        }
        return true;
    }
}
