package com.datastructure.problems.Graphs;

import java.io.PipedOutputStream;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class LT200NumberOfIslands {

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        AtomicInteger count = new AtomicInteger(0);
        IntStream.range(0,row).forEach(i -> {
            IntStream.range(0,col).forEach(j -> {
                if(!visited[i][j] && grid[i][j] == '1') {
                    count.getAndIncrement();
                    dfs(i,j,visited,grid);
                }
            });
        });
        return count.get();
    }


    private void dfs(int row, int col, boolean[][] visited, char[][] grid) {
        var pairQueue = new ArrayDeque<Position>();
        visited[row][col] = true;
        pairQueue.offer(new Position(row, col));

        int[][] DIRECTIONS = {
                {-1, 0},  // Up
                {1, 0},   // Down
                {0, -1},  // Left
                {0, 1}    // Right
        };


        while(!pairQueue.isEmpty()) {
            var pair = (Position) pairQueue.peek();
            int visitRow = pair.row();
            int visitCol = pair.col();
            pairQueue.poll();

            // four conditions
            Arrays.stream(DIRECTIONS).forEach(d-> {
                checkAndmarkPosition(visitRow,visitCol,d[0],d[1],pairQueue,visited,grid);
            });
        }

    }
    private record Position(int row, int col) {}

    private void checkAndmarkPosition(int visitRow, int visitCol, int deltaRow, int deltaCol,
                                      ArrayDeque<Position> pairQueue,  boolean[][] visited,
                                      char[][] grid ) {
        int n = grid.length;
        int m = grid[0].length;
        int neighbourRow = visitRow + deltaRow;
        int neighbourCol = visitCol + deltaCol;
        if (
                neighbourRow >= 0 && neighbourCol >= 0
                        && neighbourRow < n && neighbourCol < m
                        && grid[neighbourRow][neighbourCol] == '1'
                        && !visited[neighbourRow][neighbourCol]) {

            visited[neighbourRow][neighbourCol] = true;
            pairQueue.offer(new Position(neighbourRow, neighbourCol));
        }
    }

    public static void main(String[] args) {
//        char[][]  grid ={
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}
//    };

        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };


        var lt = new LT200NumberOfIslands();
        System.out.println(lt.numIslands(grid));
    }
}
