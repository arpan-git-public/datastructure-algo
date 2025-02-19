package com.datastructure.problems.Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {

    List<Integer> topologicalOrder(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            adjList.add(new ArrayList<>());
        }

        int i = 0;
        for(int[] edge : graph) {
            for(int node : edge) {
                adjList.get(i).add(node);
            }
            i++;
        }
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for(int j = 0 ; j < n; j++) {
            if(!visited[j]) {
                dfs(j,adjList,visited,stack);
            }
        }
        List<Integer> result = new ArrayList<>();

         while(!stack.isEmpty()) {
            int element = stack.peek();
            result.add(element);
            stack.pop();
        }
        return result;
    }

    void dfs(int node, List<List<Integer>> adjList, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for(int nnode : adjList.get(node)) {
            if(!visited[nnode])
               dfs(nnode,adjList,visited,stack);

        }
        stack.add(node);
    }

    public static void main(String[] args) {
        int[][] graph = {{},{},{3},{1},{0,1},{0,2}};
        var lt = new TopologicalSortDFS();
        lt.topologicalOrder(graph).forEach(x-> System.out.print(x + " "));
    }
}
