package com.datastructure.problems.Graphs;

import java.util.Arrays;

/**
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
 *
 * A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
 *
 * Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
 * Example 2:
 *
 *
 * Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * Output: 0
 * Explanation: All 1s are either on the boundary or can reach the boundary.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 500
 * grid[i][j] is either 0 or 1.
 */
public class LT1020NumberOfEnclaves {
    int[][] DIRECTION = {
            {0,-1},
            {0,1},
            {-1,0},
            {1,0}
    };
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i<n ;i++) {
            if(!visited[i][0] && grid[i][0] == 1){
                dfs(i,0,n,m,grid,visited);
            }
            if(!visited[i][m-1] && grid[i][m-1] == 1) {
                dfs(i,m-1,n,m,grid,visited);
            }
        }

        for(int j = 0 ; j < m; j++) {
            if(!visited[0][j] && grid[0][j] == 1 ) {
                dfs(0,j,n,m,grid,visited);
            }
            if(!visited[n-1][j] && grid[n-1][j] == 1) {
                dfs(n-1,j,n,m,grid,visited);
            }
        }
        int numOfEnclaves = 0;
        for(int i = 0; i< n ; i++) {
            for(int j =0; j< m; j++) {
                if(!visited[i][j] && grid[i][j] == 1)
                    numOfEnclaves++;
            }
        }
        return numOfEnclaves;
    }

    void dfs(int row, int col, int n, int m, int[][] grid, boolean[][] visited) {
        if(!(row >= 0 && col >= 0 && row < n && col < m && !visited[row][col] && grid[row][col] == 1))
            return;

        visited[row][col] = true;

        Arrays.stream(DIRECTION).forEach(d -> {
            dfs(row+d[0],col+d[1],n,m,grid,visited);
        });
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        var lt = new LT1020NumberOfEnclaves();
        System.out.println(lt.numEnclaves(grid));
    }
}
