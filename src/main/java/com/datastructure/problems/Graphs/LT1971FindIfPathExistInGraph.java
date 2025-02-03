package com.datastructure.problems.Graphs;

import java.util.*;

public class LT1971FindIfPathExistInGraph {

    /**
     * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
     *
     * You want to determine if there is a valid path that exists from vertex source to vertex destination.
     *
     * Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
     * n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
     *
     * @param n
     * @param edges
     * @param source
     * @param destination
     * @return
     */

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++) {
            map.putIfAbsent(i,new ArrayList<>());
        }
        for(int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
         queue.add(source);
        while(!queue.isEmpty()) {
            int node = queue.poll();

            if(node == destination)
                 return true;

            if(!visited[node]) {
                visited[node] = true;
                for(int neighbour : map.get(node)) {
                    queue.add(neighbour);
                }
            }
        }
        return false;
    }


    public boolean validPath_dfs(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        //add adjacent edge list
        for(int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        //dfs
        boolean[] visited = new boolean[n];
        int node = source;
        return dfs(node, map, source, destination, visited );
    }

    boolean dfs(int node, Map<Integer,List<Integer>> map,int source, int destination, boolean[] visited ) {
        if (node == destination)
            return true;
        //base condition
        if(visited[node])
            return false;

        visited[node] = true;
        //choice loop
        for(int neighbour : map.get(node)) {
            if(dfs(neighbour,map,source,destination,visited)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 3, source = 0, destination = 2;
        int[][] edges = {{0,1},{1,2},{2,0}};
        var obj = new LT1971FindIfPathExistInGraph();
        System.out.println(obj.validPath_dfs(n,edges,source,destination));
    }
}
