package com.datastructure.problems.Graphs;

import java.util.*;

public class ShortestPathInUndirectedGraph {

    int[] shortestPathInUG(int[][] graph){
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < graph.length;i++) {
            adjList.add(new ArrayList<>());
        }

        // create adjList
        int j = 0;
        for(int[] edge: graph) {
            for(int node: edge) {
                adjList.get(j).add(node);
                adjList.get(node).add(j);
            }
            j++;
        }

        Queue<Pair> q = new ArrayDeque<>();
        int[] distance  = new int[graph.length];
        Arrays.fill(distance,Integer.MAX_VALUE);
        q.offer(new Pair(0,0));
        distance[0] = 0;

        while(!q.isEmpty()) {
            Pair pair = q.poll();
            for(int nnode : adjList.get(pair.node())) {
                if(distance[pair.dis()] != Integer.MAX_VALUE
                  && distance[nnode] == Integer.MAX_VALUE) {
                    distance[nnode] = pair.dis() + 1;
                    q.offer(new Pair(nnode,  distance[nnode]));
                }
            }

        }

        return distance;
     }

     private record Pair(int node, int dis) {}

    public static void main(String[] args) {
        int[][] graph = {{1,3},{2},{6},{4},{5},{6},{7,8},{},{}};
        var lt = new ShortestPathInUndirectedGraph();
        int[] distance = lt.shortestPathInUG(graph);
        Arrays.stream(distance).forEach(x -> System.out.print(x + "  "));

    }
}
