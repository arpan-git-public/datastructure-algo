package com.datastructure.problems.Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CycleDetectBFS {
    boolean detectCycle(int numOfNodes, int[][] edges) {

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0;i < numOfNodes; i++) {
            adjList.add(new ArrayList<>());
        }
        int j = 0;
        for(int[] edge: edges) {
            for(int node : edge) {
                adjList.get(j).add(node);
            }
            j++;
        }


        boolean[] visited = new boolean[numOfNodes];

        for(int i = 0; i < visited.length; i++) {
           if(!visited[i]) {
               if (detectCycle(i, adjList, visited)) return true;
           }
        }

        return false;
    }

    private static boolean detectCycle(int src, List<List<Integer>> adjList, boolean[] visited) {
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(src, -1));
        visited[src] = true;
        while (!q.isEmpty()) {
            Pair node = q.peek();
            q.poll();
            for(int neighbour : adjList.get(node.node())) {
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.offer(new Pair(neighbour,node.node()));
                } else if(visited[neighbour] && neighbour != node.parent())
                    return true;
            }
        }
        return false;
    }

    private record Pair(int node, int parent) {}
    public static void main(String[] args) {
        var obj = new CycleDetectBFS();
        int[][] adj = {{1},{0,2,3},{1,3,4},{1,3},{2}};
        //int[][] adj = {{1},{0,2,3},{1,4},{1},{2}};
        //int[][] adj = {{1},{0,2},{1,3},{0,2}};
        System.out.println(obj.detectCycle(5,adj));
    }
}
