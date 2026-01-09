package com.dsa_algorithms.Tree.Traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC417 {
// 1. it would be much better to understand if we have two seperate vis array one for pacific and another for atlantic
    static class Cord{
        int x, y, type;
        public Cord(int x, int y, int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int i, j, m = heights.length, n = heights[0].length, connected = 3;
        int[][] vis = new int[m+2][n+2];
        Queue<Cord> queue = new LinkedList<>();

        initializePacific(queue, vis, m, n);
        bfs(queue, vis, m, n, heights);
        queue = new LinkedList<>();
        initializeAtlantic(queue, vis, m, n);
        return bfs(queue, vis, m, n, heights);
    }
    private List<List<Integer>> bfs(Queue<Cord> queue, int[][] vis, int m, int n, int[][] heights){
        int connected = 3;
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        List<List<Integer>> cordinates = new ArrayList<>();

        while(!queue.isEmpty()){
            Cord cord = queue.poll();
            for(int[] dir:dirs){
                int x = cord.x+dir[0], y = cord.y+dir[1], type = cord.type;
                if (x > 0 && y > 0 && x <=m && y <= n && vis[x][y] < type && (cord.x == 0 || cord.y == 0 || cord.x == m+1 || cord.y == n+1 || heights[x-1][y-1] >= heights[cord.x-1][cord.y-1])){
                    vis[x][y] = Math.min(connected, vis[x][y]+type);
                    Cord newCord = new Cord(x, y, vis[x][y]);
                    queue.offer(newCord);
                    if (vis[x][y] == connected){
                        cordinates.add(Arrays.asList(x-1, y-1));
                    }
                }
            }
        }
        return cordinates;
    }
    private void initializePacific(Queue<Cord> queue, int[][] vis, int m, int n){
        int i, j;
        Cord cord;
        for(j=0; j<=n+1; j++){
            cord = new Cord(0, j, 1);
            queue.offer(cord);
            vis[0][j] = 1;
        }
        for(i=0; i<=m; i++){
            cord = new Cord(i, 0, 1);
            queue.offer(cord);
            vis[i][0] = 1;
        }
    }
    private void initializeAtlantic(Queue<Cord> queue, int[][] vis, int m, int n){
        int i, j;
        Cord cord;
        for(j=0; j<=n+1; j++){
            cord = new Cord(m+1, j, 2);
            queue.offer(cord);
            vis[m+1][j] = 2;
        }
        for(i=1; i<=m+1; i++){
            cord = new Cord(i, n+1, 2);
            queue.offer(cord);
            vis[i][n+1] = 2;
        }
    }
}
