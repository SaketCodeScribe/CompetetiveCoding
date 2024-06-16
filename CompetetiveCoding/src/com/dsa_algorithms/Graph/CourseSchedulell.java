package com.dsa_algorithms.Graph;
import java.util.*;
import java.util.stream.IntStream;

public class CourseSchedulell {
    static List<Integer> ans;
    static List<List<Integer>> adj;
    /*
        *** Kahn's Algorithm
     */
    public static List<Integer> findSchedule(int numCourses, List<List<Integer>> prerequisites) {
        // Write your code here.
        ans = new ArrayList<>();
        adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[numCourses+1];

        IntStream.range(0, numCourses+1).forEach(i -> adj.add(new ArrayList<>()));

        for(List<Integer> prerequisite:prerequisites){
            adj.get(prerequisite.get(0)).add(prerequisite.get(1));
            indegree[prerequisite.get(1)]++;
        }
        IntStream.range(1, numCourses+1).forEach(i -> {
            if (indegree[i] == 0)
                queue.add(i);
        });

        while(!queue.isEmpty()){
            int node = queue.poll();
            ans.add(node);
            for(int child:adj.get(node)){
                indegree[child]--;
                if (indegree[child] == 0)
                    queue.add(child);
            }
        }
        for(int i=1; i<=numCourses; i++){
            if (indegree[i] > 0)
                return new ArrayList<>();
        }
        Collections.reverse(ans);
        return ans;
    }

    /*
     *** DFS
     */
    static boolean[] vis;
    public static List<Integer> findSchedule1(int numCourses, List<List<Integer>> prerequisites) {
        // Write your code here.
        ans = new ArrayList<>();
        adj = new ArrayList<>();
        vis = new boolean[numCourses+1];
        IntStream.range(0, numCourses+1).forEach(i -> adj.add(new ArrayList<>()));

        for(List<Integer> prerequisite:prerequisites)
            adj.get(prerequisite.get(0)).add(prerequisite.get(1));

        for(int i=1; i<= numCourses; i++){
            if (!vis[i]){
                if (!dfs(i, -1))
                    return new ArrayList<>();
            }
        }
        return ans;
    }
    public static boolean dfs(int node, int par){
        vis[node] = true;
        for(int child:adj.get(node)){
            if (vis[child])
                return false;
            if (!dfs(child, node))
                return false;
        }
        ans.add(node);
        return true;
    }
}
