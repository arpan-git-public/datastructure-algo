package com.datastructure.problems.Graphs;

import java.util.*;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
 *
 * Return the number of distinct islands.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]
 * Output: 1
 * Example 2:
 *
 *
 * Input: grid = [[1,1,0,1,1],[1,0,0,0,0],[0,0,0,0,1],[1,1,0,1,1]]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 */
public class LT694NumberOfDistinctIslands {

    public int numDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();

        Set<List<Pair>> islandsSet = new HashSet<>();

        for(int i = 0 ; i < n ;i++) {
            for(int j = 0 ; j < m ; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    List<Pair> pairs = new ArrayList<>();
                    Pair basePair = new Pair(i,j);
                    dfs(i,j,n,m,grid,visited,pairs, basePair );
                    islandsSet.add(pairs);
                }
            }
        }

        return islandsSet.size();
    }

    void dfs(int row, int col, int n , int m , int[][] grid,
             boolean[][] visited, List<Pair> pairs, Pair base) {
        if(!(row >= 0 && col >= 0 && row < n && col < m
                && !visited[row][col] && grid[row][col] == 1))
            return;
        visited[row][col] = true;
        pairs.add(new Pair(row - base.row(),col - base.col()));

        dfs(row,col-1,n,m,grid,visited,pairs,base);
        dfs(row,col+1,n,m,grid,visited,pairs,base);
        dfs(row-1,col,n,m,grid,visited,pairs,base);
        dfs(row+1,col,n,m,grid,visited,pairs,base);
    }

    private record Pair(int row, int col) {}

    public static void main(String[] args) {
        int[][] islands = {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        var lt = new LT694NumberOfDistinctIslands();
        System.out.println(lt.numDistinctIslands(islands));
    }
}
