package com.datastructure.problems.Graphs;

import java.util.*;

public class LT802FindEventualSafeStates {

    public List<Integer> eventualSafeNodes_BFS(int[][] graph) {
        //insert as an reverse edges
        //count in-degree of nodes
        //queue zero degree based nodes and remove the edge
        // check the size of list which has removed nodes.
        int n = graph.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i <n ; i++) {
            adjList.add(new ArrayList<>());
        }

        int j = 0;
        int[] indegree = new int[n];
        for(int[] edge : graph) {
            for(int node: edge) {
                adjList.get(node).add(j);
                indegree[j]++;
            }
            j++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> topo = new ArrayList<>();
        for(int k = 0 ; k < n ;k++) {
            if(indegree[k] == 0)
                q.offer(k);
        }

        while(!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            topo.add(node);
            for(int nnode : adjList.get(node)) {
                indegree[nnode]--;
                if(indegree[nnode] == 0) q.offer(nnode);
            }
        }

        topo.sort(Comparator.naturalOrder());
        return topo;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < graph.length; i++) {
            adjList.add(new ArrayList<>());
        }
        int j = 0;
        for(int[] edge : graph) {
            for(int node : edge) {
                adjList.get(j).add(node);
            }
            j++;
        }

        boolean[] visited = new boolean[graph.length];
        boolean[] pathVisited = new boolean[graph.length];
        List<Integer> safeNodes = new ArrayList<>();

        for(int i = 0 ; i < graph.length; i++) {
            if(!visited[i]) {
                dfs(i,adjList,visited,pathVisited,safeNodes);
            }
        }

        //sort the safeNodes
       safeNodes.sort(Comparator.naturalOrder());
        return safeNodes;
    }

    boolean dfs(int node, List<List<Integer>> adjList, boolean[] visited, boolean[] pathVisited, List<Integer> safeNodes) {


        visited[node] = true;
        pathVisited[node] = true;

        for(int nnode : adjList.get(node)) {
            if(!visited[nnode]) {
                if(dfs(nnode,adjList,visited,pathVisited,safeNodes)){
                   if(safeNodes.contains(nnode))
                       safeNodes.remove(nnode);
                    return true;
                }
            } else if(visited[nnode] && pathVisited[nnode]) {
                if(safeNodes.contains(nnode))
                    safeNodes.remove(nnode);
                return true;
            }
        }

        safeNodes.add(node);
        pathVisited[node] = false;
        return false;
    }
    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        var lt = new LT802FindEventualSafeStates();
        lt.eventualSafeNodes(graph).stream().forEach(x-> System.out.print(x + " "));
        System.out.println();
        lt.eventualSafeNodes_BFS(graph).stream().forEach(x-> System.out.print(x + " "));
    }
}
