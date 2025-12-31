package com.dsa_algorithms.Graph.DjisktraAlgo;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC1970 {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,-1},{-1,1},{-1,-1},{1,1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        Map<String, Integer> map = new HashMap<>();

        initialize(cells, map, pq);

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            String node = top[0]+","+top[1];
            int time = top[2];
            if (top[1] == col-1){
                return time;
            }
            if (map.containsKey(node)){
                map.remove(node);
                for(int[] dir:dirs){
                    int x = top[0]+dir[0], y = top[1]+dir[1];
                    if (map.containsKey(x+","+y)){
                        pq.offer(new int[]{x, y, Math.max(time, map.get(x+","+y))});
                    }
                }
            }
        }
        return 0;
    }
    private void initialize(int[][] cells, Map<String, Integer> map, PriorityQueue<int[]> pq){
        int i;

        for(i=0; i<cells.length; i++){
            int x = cells[i][0]-1, y = cells[i][1]-1;
            map.put(x+","+y, i);
            if (y == 0){
                pq.offer(new int[]{x, y, i});
            }
        }
    }
}
