package com.datastructure.problems.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgo {



    int[] shortestPath(int[][] graph) {
        List<List<Pair>> adjList = new ArrayList<>();
        //prepare adjList using list of list of edges between two nodes.

        // create a priority queue which acts min heap
        // add the pair to queue and start breadth first search
        // keep polling the element
        // and check the distance between two nodes if it is min than previous one then use and add pair to queue.
        // populate the distance array
        // do this until q become empty
        for(int i = 0 ; i < graph.length; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i = 0 ; i < graph.length;i++) {
            for(int j = 0 ; j < graph[0].length; j++) {
                if(graph[i][j] > 0) {
                    adjList.get(i).add(new Pair(j, graph[i][j]));
                    adjList.get(j).add(new Pair(i, graph[i][j]));
                }
            }
        }
        PriorityQueue<Pair> q = new PriorityQueue<>();
        int[] distance = new int[graph.length];
        Arrays.fill(distance,Integer.MAX_VALUE);
        q.offer(new Pair(0,0));
        distance[0] = 0;
        while(!q.isEmpty()) {
            Pair pair = q.peek();
            q.poll();

            for(Pair npair : adjList.get(pair.node())) {
                if(distance[pair.node()] + npair.dist() < distance[npair.node()]) {
                    distance[npair.node()] = distance[pair.node()] + npair.dist();
                    q.offer(new Pair(npair.node(), distance[npair.node()]));
                }
            }
        }

        return distance;
}

    private record Pair(int node, int dist) implements Comparable<Pair> {

        @Override
        public int compareTo(Pair o) {
            if(this.dist() <= o.dist() ) return -1;
            return 1;
        }
    }



    public static void main(String[] args) {
        int[][] graph = {{0,2,0,0,1,0},
                {0,0,3,0,0,0},
                {0,0,0,6,0,0},
                {0,0,0,0,0,0},
                {0,0,2,0,0,4},
                {0,0,0,1,0,0}
        };
        var lt = new DijkstraAlgo();
        Arrays.stream(lt.shortestPath(graph)).forEach(x -> System.out.print(x + " "));
    }
}
