package com.dsa_algorithms.BackTracking;

import java.util.*;

public class ReconstructItinerary {
    List<String> ans;
    Map<String, TreeMap<String, Integer>> map;
    public List<String> findItinerary(List<List<String>> tickets) {
        ans = new ArrayList<>();
        map = new HashMap<>();
        if (tickets == null || tickets.size() == 0)
            return ans;
        for(List<String> ticket:tickets){
            String dep = ticket.get(0), arr = ticket.get(1);
            if (map.get(dep) == null)
                map.put(dep, new TreeMap<>());
            TreeMap<String, Integer> tree = map.get(dep);
            tree.put(arr, tree.getOrDefault(arr,0)+1);
        }
        dfs("JFK", tickets.size());
        return ans;
    }
    public boolean dfs(String node, int tot){
        ans.add(node);
        if (tot == 0)
            return true;
        if (map.get(node) == null)
            return false;
        for(Map.Entry<String, Integer> entry:map.get(node).entrySet()){
            String child = entry.getKey();
            int cnt = entry.getValue();
            if (cnt == 0)
                continue;
            entry.setValue(cnt-1);
            if (dfs(child, tot-1))
                return true;
            ans.remove(ans.size()-1);
            entry.setValue(entry.getValue()+1);
        }
        return false;
    }
}
