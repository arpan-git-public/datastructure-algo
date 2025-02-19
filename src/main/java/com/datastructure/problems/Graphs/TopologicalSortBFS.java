package com.datastructure.problems.Graphs;

import java.util.*;

/**
 *  Two ways :
 *  1. Kahn's Algorithm (In degree)
 *  2. Stack + Queue
 */
public class TopologicalSortBFS {
    List<Integer> topologicalOrderKahnAlgo(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            adjList.add(new ArrayList<>());
        }

        int j = 0;
        int[] inDegree = new int[n];
        for(int[] edge : graph) {
            for(int node : edge) {
                adjList.get(j).add(node);
                inDegree[node]++;
            }
            j++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        for(int  i = 0 ; i < n ;i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            result.add(node);
            for(int edge : adjList.get(node)) {
                inDegree[edge]--;
                if(inDegree[edge] == 0) q.offer(edge);
            }
        }
        return result;
    }
    List<Integer> topologicalOrder(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            adjList.add(new ArrayList<>());
        }

        int j = 0;
        for(int[] edge : graph) {
            for(int node : edge) {
                adjList.get(j).add(node);
            }
            j++;
        }

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < n;i++) {
            if(!visited[i])
                bfs(i,adjList,visited,stack,list);
        }
        Collections.reverse(list);
        return list;
    }

    void bfs(int start, List<List<Integer>> adjList, boolean[] visited,Stack<Integer> stack, List<Integer> orderList) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int node = q.peek();
            stack.add(node);
            q.poll();
            for(int nnode : adjList.get(node)) {
                if(!visited[nnode]) {
                    visited[nnode] = true;
                    q.offer(nnode);
                }
            }
        }

        while(!stack.isEmpty()) {
            orderList.add(stack.pop());
        }

    }

    public static void main(String[] args) {
        int[][] graph = {{},{},{3},{1},{0,1},{0,2}};
        var lt = new TopologicalSortBFS();
        lt.topologicalOrder(graph).forEach(x-> System.out.print(x + " "));
        System.out.println();
        lt.topologicalOrderKahnAlgo(graph).forEach(x-> System.out.print(x + " "));

    }
}
