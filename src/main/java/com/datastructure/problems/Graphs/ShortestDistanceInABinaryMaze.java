package com.datastructure.problems.Graphs;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestDistanceInABinaryMaze {

    /**
     *             {1, 1, 1, 1},    {0,0,0,0}
     *             {1, 1, 0, 1},    {0,0,0,0}
     *             {1, 1, 1, 1},    {0,0,0,0}
     *             {1, 1, 0, 0},    {0,0,0,0}
     *             {1, 0, 0, 1}}    {0,0,0,0}
     *
     *  [0,1] -> [1,0,0] -> []
     *          [1,0,2]
     *          [1,1,1]
     */

    int shortestDistance(int[][] matrix, int[] source, int[] destination ) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] distance = new int[n][m];
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(0,source[0],source[1]));

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        while(!q.isEmpty()) {
            Pair pair = q.peek();
            q.poll();

            if(pair.xCor() == destination[0] && pair.yCor() == destination[1])
                return pair.dist();

            int left = pair.yCor()-1;
            int right = pair.yCor() + 1;
            int up = pair.xCor() -1;
            int bottom = pair.xCor() + 1;

            if(left >= 0 && matrix[pair.xCor()][left] == 1) {
                if(pair.dist() + 1 < distance[pair.xCor()][left]) {
                    distance[pair.xCor()][left] = pair.dist() + 1;
                    q.offer(new Pair(pair.dist()+1,pair.xCor(),left));
                }
            }
            if(right < m && matrix[pair.xCor()][right] == 1) {
                if(pair.dist() + 1 < distance[pair.xCor()][right]) {
                    distance[pair.xCor()][right] = pair.dist() + 1;
                    q.offer(new Pair(pair.dist()+1,pair.xCor(),right));
                }
            }

            if(up >= 0 && matrix[up][pair.yCor()] == 1) {
                if(pair.dist() + 1 < distance[up][pair.yCor()]) {
                    distance[up][pair.yCor()] = pair.dist() + 1;
                    q.offer(new Pair(pair.dist()+1,up,pair.yCor()));
                }
            }
            if(bottom >= 0 && matrix[bottom][pair.yCor()] == 1) {
                if(pair.dist() + 1 < distance[bottom][pair.yCor()]) {
                    distance[bottom][pair.yCor()] = pair.dist() + 1;
                    q.offer(new Pair(pair.dist()+1,bottom,pair.yCor()));
                }
            }
        }
      return -1;
    }

    private record Pair(int dist, int xCor, int yCor) {

    }

    public static void main(String[] args) {
       int grid[][] = {{1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}};
      int[]  source = {0, 1};
       int[] destination = {2, 2};

//       int grid[][] = {{1, 1, 1, 1, 1},
//            {1, 1, 1, 1, 1},
//            {1, 1, 1, 1, 0},
//            {1, 0, 1, 0, 1}};
//        int[] source = {0, 0};
//        int[] destination = {3, 4};

       var lt = new ShortestDistanceInABinaryMaze();
        System.out.println(lt.shortestDistance(grid,source,destination));
    }
}
