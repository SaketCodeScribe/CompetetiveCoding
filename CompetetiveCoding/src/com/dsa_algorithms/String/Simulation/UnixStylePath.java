package com.dsa_algorithms.String.Simulation;

import java.util.*;
public class UnixStylePath {
    public String simplifyPath(String path) {
        int i = 0, n;
        String[] str = path.split("/");
        List<String> arr = new ArrayList<>();
        StringBuilder ans = new StringBuilder();

        n = str.length;

        while(i < n){
            if (str[i].equals("..")){
                if (!arr.isEmpty())
                    arr.remove(arr.size()-1);
            }
            else if (!str[i].equals("") && !str[i].equals(".")){
                arr.add(str[i]);
            }
            i++;
        }
        for(i=0; i<arr.size(); i++){
            ans.append("/");
            ans.append(arr.get(i));
        }
        return ans.isEmpty() ? "/" : ans.toString();
    }
}
