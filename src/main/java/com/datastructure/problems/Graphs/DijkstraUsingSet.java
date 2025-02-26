package com.datastructure.problems.Graphs;

import java.util.*;

public class DijkstraUsingSet {

    int[] shortestPathUsingSet(int[][] graph) {
        List<List<Pair>> adjList = new ArrayList<>();

        for(int i = 0 ; i < graph.length; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                if(graph[i][j] > 0) {
                    adjList.get(i).add(new Pair(j,graph[i][j]));
                    adjList.get(j).add(new Pair(i,graph[i][j]));
                }
            }
        }

        Set<Integer> unSettedSet = new HashSet<>();
        Set<Integer> settledSet = new HashSet<>();
        int[] distance = new int[graph.length];
        Arrays.fill(distance,Integer.MAX_VALUE);
        unSettedSet.add(0);
        distance[0] = 0;

        while(!unSettedSet.isEmpty()) {
            //get Lowest distance node from unsettled set.
            Integer node = getLowestDistanceNode(unSettedSet);
            unSettedSet.remove(node);

            for(Pair nnode: adjList.get(node)) {
                    if (distance[node] + nnode.dist() < distance[nnode.node()]) {
                        distance[nnode.node()] = distance[node] + nnode.dist();
                        unSettedSet.add(nnode.node());
                    }
            }
            settledSet.add(node);
        }
        return distance;
    }

    private Integer getLowestDistanceNode(Set<Integer> unSettedSet) {
        int min = Integer.MAX_VALUE;
        for(Integer node : unSettedSet) {
            min = Math.min(node,min);
        }
        return min;
    }

    private record Pair(int node, int dist) {}

    public static void main(String[] args) {
        int[][] graph = {{0,2,0,0,1,0},
                {0,0,3,0,0,0},
                {0,0,0,6,0,0},
                {0,0,0,0,0,0},
                {0,0,2,0,0,4},
                {0,0,0,1,0,0}
        };
        var lt = new DijkstraUsingSet();
        Arrays.stream(lt.shortestPathUsingSet(graph)).forEach(x -> System.out.print(x + " "));

    }
}
