package com.datastructure.problems.Graphs;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionDFS {

    boolean detectCycle(int numOfNodes, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numOfNodes ; i++) {
            adj.add(i,new ArrayList<>());
        }
        int i = 0;
        for(int[] edge : edges) {
            for(int node : edge) {
                adj.get(i).add(node);
            }
            i++;
        }
        int parent = -1;
        boolean[] visited = new boolean[numOfNodes];
        // this loop covers isolated multiple subgrap like if second component is separate
        // than first component of graph.
        for(i = 0; i < numOfNodes ; i++) {
            if(!visited[i]) {
               if(dfs(i,adj, visited, parent))
                     return true;
            }
        }
        return false;
    }

    boolean dfs(int node, List<List<Integer>> adj,boolean[] visited, int parent){
        visited[node] = true;

        for(int neighbour : adj.get(node)) {
            if(!visited[neighbour]) {
                parent = node;
                if(dfs(neighbour,adj,visited,parent))
                    return true;
            } else if(visited[neighbour] && parent != neighbour) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        var obj = new CycleDetectionDFS();
       // int[][] adj = {{1},{0,2,3},{1,3,4},{1,3},{2}};
        int[][] adj = {{1},{0,2,3},{1,4},{1},{2}};
        System.out.println(obj.detectCycle(5,adj));
    }
}
