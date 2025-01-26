package org.example.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LT1466ReorderRoutestoMakeAllPathsLeadtotheCityZero {

    /**
     * Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
     * Output: 3
     * Explanation: Change the direction of edges show in red such that
     * each node can reach the node 0 (capital).
     *
     * @param n
     * @param connections
     * @return
     */
    int reorderCount = 0;

    public int minReorder(int n, int[][] connections) {

        List<List<Integer>> forwardRoutes = new ArrayList<>(n);
        List<List<Integer>> backwardRoutes = new ArrayList<>(n);
        for(int i = 0 ; i < n ; i++) {
            forwardRoutes.add(new ArrayList<>());
            backwardRoutes.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            forwardRoutes.get(connection[0]).add(connection[1]);
            backwardRoutes.get(connection[1]).add(connection[0]);
        }
        boolean[] visited = new boolean[n];


        dfs(0, forwardRoutes, backwardRoutes, n, visited);
        return reorderCount;
    }

    void dfs(int node,List<List<Integer>> forwardEdges, List<List<Integer>> backwardEdges, int n, boolean[] visited) {
        visited[node] = true;

          for (int edge : forwardEdges.get(node)) {
                if (!visited[edge]) {
                    reorderCount++;
                    dfs(edge, forwardEdges, backwardEdges, n, visited);
                }
            }



            for (int edge : backwardEdges.get(node)) {
                if (!visited[edge]) {
                    dfs(edge, forwardEdges, backwardEdges, n, visited);
                }
            }

    }

    public static void main(String[] args) {
        int n = 6;
         int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
       // int[][] connections = {{4, 5}, {0, 1}, {1, 3}, {2, 3}, {4, 0}};
        var lt = new LT1466ReorderRoutestoMakeAllPathsLeadtotheCityZero();
        System.out.println(lt.minReorder(n, connections));
    }
}
