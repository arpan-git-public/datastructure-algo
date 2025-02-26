package com.datastructure.problems.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDirectedAcyclicGraph {

    int[] shortestDistanceInDAG(int[][] graph,int source){
        //create adjList
        List<List<Pair>> adjList =  new ArrayList<>();
        for(int i = 0 ; i< graph.length; i++) {
            adjList.add(new ArrayList<>());
        }

       for(int row = 0; row < graph.length; row++) {
           for(int col = 0 ; col < graph[row].length; col++) {
                if(graph[row][col] > 0) {
                    adjList.get(row).add(new Pair(col,graph[row][col]));
                }
           }
       }
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        // dfs and visit the graph and prepare topological order
        for(int i = 0 ; i < visited.length;i++) {
            if(!visited[i]) {
                dfs(i,adjList,visited,stack);
            }
        }

        //pop the element from stack and count distance from that node to adj node
        // assign source node to 0 and start the journey.
        int[] distance = new int[graph.length];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        while(!stack.isEmpty()) {
            int node = stack.peek();
            stack.pop();
            if (distance[node] != Integer.MAX_VALUE) {
                for (Pair pair : adjList.get(node)) {
                    if (distance[node] + pair.weight() < distance[pair.node()])
                        distance[pair.node()] = distance[node] + pair.weight();
                }
            }
        }

        return distance;
    }

    void dfs(int node, List<List<Pair>> adjList, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for(Pair nnode : adjList.get(node)) {
            if(!visited[nnode.node()]){
                dfs(nnode.node(),adjList,visited,stack);
            }
        }
        stack.add(node);
    }

    private record Pair(int node, int weight) {}

    public static void main(String[] args) {
        int[][] graph = {{0,2,0,0,1,0},
                {0,0,3,0,0,0},
                {0,0,0,6,0,0},
                {0,0,0,0,0,0},
                {0,0,2,0,0,4},
                {0,0,0,1,0,0}
        };
        var lt = new ShortestPathInDirectedAcyclicGraph();
        int[] distance = lt.shortestDistanceInDAG(graph,5);
        Arrays.stream(distance).forEach(x-> System.out.println(x + " "));

    }
}
