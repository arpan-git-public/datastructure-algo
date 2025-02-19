package com.datastructure.problems.Graphs;

import java.util.*;

public class CycleDetectionDirectedGraphBFS {

    boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < V ; i++)
            adjList.add(new ArrayList<>());
        int j = 0;
        int[] indegree = new int[V];
        for(int[] edge : edges) {
            for(int node : edge) {
                adjList.get(j).add(node);
                indegree[node]++;
            }
            j++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        int count = 0;
        for(int i =0 ; i < V; i++) {
            if(indegree[i] == 0)
                q.offer(i);
        }

        while(!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            count++;
            for(int nnode : adjList.get(node)) {
                indegree[nnode]--;
                if(indegree[nnode] == 0) q.offer(nnode);
            }
        }
        List<Integer> topo = new ArrayList<>();
        topo.stream().mapToInt(i->i).toArray();

       return count == V;
    }

    public static void main(String[] args) {
        int[][] edges = {{3},{3},{4},{2},{3}};
        var lt = new CycleDetectDirectedGraph();
        System.out.println(lt.isCyclic(5,edges));
    }
}
