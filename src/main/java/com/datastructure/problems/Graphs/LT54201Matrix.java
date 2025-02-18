package com.datastructure.problems.Graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class LT54201Matrix {

    private static final int[][] DISTANCE = {
            {0,-1},
            {0,1},
            {-1,0},
            {1,0}
    };
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];
        Queue<Pair> q = new ArrayDeque<>();

        IntStream.range(0,n).forEach(row -> {
            IntStream.range(0,m).forEach(col -> {
                if(mat[row][col] == 0){
                    q.offer(new Pair(row,col,new AtomicInteger(0)));
                    visited[row][col] = true;
                    distance[row][col] = 0;
                }
            });
        });

        while(!q.isEmpty()) {
            Pair pair = q.peek();
            int row = pair.row();
            int col = pair.col();
            q.poll();
            AtomicInteger initialDistance = pair.distance();

            Arrays.stream(DISTANCE).forEach(d-> {
                int nrow = row + d[0];
                int ncol = col + d[1];

                if(nrow >=0 && ncol >= 0 && nrow < n && ncol < m &&
                    !visited[nrow][ncol] && mat[nrow][ncol] == 1) {
                        visited[nrow][ncol] = true;
                        distance[nrow][ncol] = initialDistance.get() + 1;
                        q.offer(new Pair(nrow,ncol,new AtomicInteger(initialDistance.get() + 1)));
                }
            });
        }
        return distance;
    }

    private record Pair(int row, int col, AtomicInteger distance){}

    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        //int[][] mat = {{0,1,0,1,1},{1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};
        var lt = new LT54201Matrix();
        int[][] result = lt.updateMatrix(mat);
        IntStream.range(0,result.length).forEach(row -> {
            System.out.println();
            IntStream.range(0,result[0].length).forEach( col -> {
                System.out.print(result[row][col] + " ");
            });
        });
    }
}
