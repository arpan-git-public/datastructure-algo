package com.datastructure.problems.DP;

import java.util.Arrays;

/**
 *  Minimum/Maximum Falling Path Sum with Variable Starting and Ending Points
 */
public class MaximumSumVariableStartAndEnd {
    int maxSumFloating(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxSum = -1;
        for(int i = 0 ; i < n ;i++) {
            maxSum = Math.max(maxSum,calculatePathSum(0,i,grid));
        }
        return maxSum;
    }

    private int calculatePathSum(int i, int j, int[][] grid) {

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length ) return 0;
        if(i == grid.length-1) return grid[i][j];
        int dl = calculatePathSum(i+1,j-1,grid);
        int d = calculatePathSum(i+1,j,grid);
        int dr = calculatePathSum(i+1,j+1,grid);

        return grid[i][j] + Math.max(dl,Math.max(d,dr));
    }


    int maxSumFloatingMemo(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxSum = -1;
        int[][] memo = new int[n][m];
        for(int i = 0 ; i < m ;i++) {
            maxSum = Math.max(maxSum,calculatePathSumMemo(0,i,grid,memo));
        }
        return maxSum;
    }

    private int calculatePathSumMemo(int i, int j, int[][] grid, int[][] memo) {

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length ) return 0;
        if(i == grid.length-1) return grid[i][j];
        if(memo[i][j] != -1) return memo[i][j];
        int dl = calculatePathSumMemo(i+1,j-1,grid, memo);
        int d = calculatePathSumMemo(i+1,j,grid,memo);
        int dr = calculatePathSumMemo(i+1,j+1,grid,memo);

        return memo[i][j] = grid[i][j] + Math.max(dl,Math.max(d,dr));
    }


    int maxSumFloatingDP(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i < n;i++) {
            dp[m-1][i] = grid[m-1][i];
        }

        for(int i = m-2 ; i >=0  ;i--) {
            for(int j = 0 ; j < n ;j++) {
                int dl = 0, d = 0, dr = 0;
                if(j > 0)  dl = dp[i+1][j-1];
                 d = dp[i+1][j];
                if(j < n-1) dr = dp[i+1][j+1];
                dp[i][j] = grid[i][j] + Math.max(dl,Math.max(d,dr));
            }
        }
      int maxSum = -1;
        for(int i = 0 ; i < n;i++) {
            maxSum = Math.max(maxSum,dp[0][i]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,20,10,4},{100,3,2,1},{10,1,20,2},{100,2,2,1}};
        var lt = new MaximumSumVariableStartAndEnd();
        System.out.println(lt.maxSumFloating(grid));
        System.out.println(lt.maxSumFloatingMemo(grid));
        System.out.println(lt.maxSumFloatingDP(grid));
    }
}
