package com.datastructure.problems.Graphs;

import java.util.*;
import java.util.function.Function;

/**
 *  Bell Man Ford Algo : Help to detect Negative cycle.
 */
public class BellmanFordAlgorithm {
    int[] shortestDistance(int n,int[][] graph) {



        int[] distance = new int[n];
        Arrays.fill(distance,(int)1e8);
        distance[0] = 0;
        for(int i = 0 ; i < n;i++){
            for(int[] edge: graph) {

                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if(distance[u] != 1e8 && distance[u] + wt < distance[v]){
                    if(i == n-1)
                        return new int[]{-1};

                    distance[v] = distance[u] + wt;
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        var lt = new BellmanFordAlgorithm();
        int n = 5;
        int[][] edges = {{1, 3, 2},
                {4, 3, -1},
                {2, 4, 1},
                {1, 2, 1},
                {0, 1, 5}};

        Arrays.stream(lt.shortestDistance(n, edges)).forEach(x-> System.out.print(x + " "));
    }
}
