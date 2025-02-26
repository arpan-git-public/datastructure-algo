package com.datastructure.problems.Graphs;

import java.util.Arrays;

public class FloydWarshallAlgorithm {
    int[][] shortestPath(int[][] dis) {
        //create a matrix
        // form a solution matrix
        // iterate from 0 to V node by considering each node as an intermediate node
        // and count dis[i][j] using dis[i][k] + dis[k][j]
        int n = dis.length;
        int m = dis[0].length;


        //add one vertices one by one
        for(int k = 0; k < n; k++) {
            //iterate over all nodes
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if( (dis[i][j] == -1 || dis[i][j] > dis[i][k] + dis[k][j]) && (dis[i][k] != -1 && dis[k][j] != -1))
                        dis[i][j]= dis[i][k] + dis[k][j];
                }
            }
        }
    return dis;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, -1, 5, -1},
                {-1, 0, 1, -1, 6},
                {2, -1, 0, 3, -1},
                {-1, -1, 1, 0, 2},
                {1, -1, -1, 4, 0}
        };

        var lt = new FloydWarshallAlgorithm();

        Arrays.stream(lt.shortestPath(graph)).forEach(
                x->{
                    Arrays.stream(x).forEach(y-> System.out.print( y + " "));
                    System.out.println();
                }
        );
    }
}
