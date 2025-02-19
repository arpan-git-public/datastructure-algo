package com.datastructure.problems.Graphs;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectDirectedGraph {

    boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i =0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        int i = 0;
        for(int[] edge : edges) {
            for(int node : edge) {
                adjList.get(i).add(node);
            }
            i++;
        }

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        //As it visits the node mark as visited true and pathVisisted as true
        // while retuning false reset the pathVisited value to false.
        //  while visiting node, If node and pathVisited are found as true then return true as cycle.

        for(int j = 0 ; j < V; j++) {
            if(!visited[j]) {
                if(dfs(j,adjList,visited,pathVisited)) return true;
            }
        }
        return false;
    }

   boolean dfs(int node, List<List<Integer>> adjList, boolean[] visited, boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true;

        for(int nnode : adjList.get(node)) {
            if(!visited[nnode]){
                if(dfs(nnode,adjList,visited,pathVisited)) return true;
            } else if(visited[node] && pathVisited[node]) return true;
        }

        pathVisited[node] = false;
        return false;
   }
    public static void main(String[] args) {
        int[][] edges = {{3},{3},{4},{2},{3}};
        var lt = new CycleDetectDirectedGraph();
        System.out.println(lt.isCyclic(5,edges));
    }
}
