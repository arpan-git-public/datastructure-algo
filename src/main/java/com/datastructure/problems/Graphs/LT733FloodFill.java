package com.datastructure.problems.Graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.IntStream;

public class LT733FloodFill {

    int[][] DIRECTIONS = {
            {-1,0}, //UP,
            {1,0}, //DOWN
            {0,-1}, //LEFT
            {0,1} //RIGHT
    };
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        Queue<Position> q = new ArrayDeque<>();
        if(image[sr][sc]==color) return image;
        int val = image[sr][sc];
        q.offer(new Position(sr, sc));
        image[sr][sc] = color;

        while(!q.isEmpty()) {
            var pair = q.peek();
            int row = pair.row();
            int col = pair.col();
            q.poll();


            Arrays.stream(DIRECTIONS).forEach(d-> {
                int deltaRow = row + d[0];
                int deltaCol = col + d[1];

                if(deltaRow >=0 && deltaCol >=0 && deltaRow < n && deltaCol < m
                        && image[deltaRow][deltaCol] == val) {
                    image[deltaRow][deltaCol] = color;
                    q.offer(new Position(deltaRow,deltaCol));
                }
            });
        }
        return image;
    }

    public int[][] floodFill_recursion(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if(original == color) return image;
        fillcolor(image,original,sr,sc,color,image.length,image[0].length);
        return image;
    }

    private void fillcolor(int[][] image, int original, int sr, int sc, int color, int n, int m) {
        if(sr < 0 && sc < 0&& sr > n && sc > m && image[sr][sc] == color ) {
            return;
        }
        image[sr][sc] = color;
        fillcolor(image,original,sr-1,sc,color,n,m); //UP
        fillcolor(image,original,sr+1,sc,color,n,m); //down
        fillcolor(image,original,sr,sc-1,color,n,m); //left
        fillcolor(image,original,sr,sc+1,color,n,m);  //right
    }

    private record Position(int row, int col) {}
    public static void main(String[] args) {
        //int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] image = {{0,0,0},{0,0,0}};
        int sr = 0, sc = 0, color = 0;
        var lt = new LT733FloodFill();
        int[][] result = lt.floodFill_recursion(image,sr,sc,color);

        IntStream.range(0,result.length).forEach(row -> {
            System.out.println();
            IntStream.range(0,result[0].length).forEach( col -> {
                System.out.print(result[row][col] + " ");
            });
        });
    }

}
