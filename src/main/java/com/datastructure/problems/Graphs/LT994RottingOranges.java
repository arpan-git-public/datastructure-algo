package com.datastructure.problems.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.OptionalInt;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class LT994RottingOranges {
    int[][] DIRECTION = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        Queue<Position> q = new LinkedList<>();
        //determine starting coordinates
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m ;j++) {
                if(grid[i][j] == 2)
                    q.offer(new Position(i,j,0));
            }
        }
        //iterate over rotten coordinates and mark fresh neighbour as rotten and increment
        while(!q.isEmpty()) {
            Position pair = q.peek();
            int row = pair.row();
            int col = pair.col();
            int time = pair.time();
            count = Math.max(count,time);
            q.poll();
            AtomicBoolean marked = new AtomicBoolean();
            Arrays
                    .stream(DIRECTION)
                    .forEach(d-> markCell(grid,row + d[0],col + d[1],time,n,m,q,marked));

        }

        OptionalInt firstRow = IntStream.range(0,grid.length)
                .filter(row -> IntStream.range(0,grid[0].length)
                        .anyMatch(col-> grid[row][col] == 1))
                .findFirst();

        return firstRow.isPresent()?-1:count;


    }

    void markCell(int[][] grid, int row, int col, int time, int n, int m, Queue<Position> q, AtomicBoolean marked) {
        if(row >= 0 && col >= 0 && row < n && col < m && grid[row][col] == 1){
            grid[row][col] = 2;
            marked.set(true);
            q.offer(new Position(row, col, ++time));
        }
    }
    private record Position(int row, int col, int time) {}

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        var lt = new LT994RottingOranges();
        System.out.println(lt.orangesRotting(grid));

        IntStream.range(0,grid.length).forEach(row -> {
            System.out.println();
            IntStream.range(0,grid[0].length).forEach( col -> {
                System.out.print(grid[row][col] + " ");
            });
        });
    }
}
