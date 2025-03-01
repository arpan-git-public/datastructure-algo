package com.datastructure.problems.DP;

import java.util.Arrays;

public class LT64MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return countMinPathSum(m-1,n-1,grid);
    }

    private int countMinPathSum(int m, int n, int[][] grid) {
        if(m == 0 && n == 0) return grid[m][n];
        if(m < 0 || n < 0) return Integer.MAX_VALUE;

        int up = countMinPathSum(m-1,n,grid);
        int left = countMinPathSum(m,n-1,grid);

        return   grid[m][n] + Math.min(up,left);
    }

    public int minPathSumRecMemo(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        Arrays.stream(memo).forEach(x-> Arrays.fill(x,-1));
        return countMinPathSumMemo(m-1,n-1,grid,memo);
    }

    private int countMinPathSumMemo(int m, int n, int[][] grid, int[][] memo) {
        if(m == 0 && n == 0) return grid[m][n];
        if(m < 0 || n < 0) return Integer.MAX_VALUE;
        if(memo[m][n] != -1) return memo[m][n];

        int up = countMinPathSumMemo(m-1,n,grid,memo);
        int left = countMinPathSumMemo(m,n-1,grid,memo);

        return memo[m][n] = grid[m][n] + Math.min(up,left);
    }

    public int minPathSumdp(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0 ; i < m; i++) {
            for(int j = 0 ; j < n;j++) {
                if(i==0 && j==0) dp[i][j] = grid[i][j];
                else {
                    int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                    if(i > 0) up = dp[i-1][j];
                    if(j > 0) left = dp[i][j-1];
                    dp[i][j] = grid[i][j] + Math.min(up,left);
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        var lt = new LT64MinimumPathSum();
        System.out.println(lt.minPathSum(grid));
        System.out.println("Recursion with Memoization Approach : ");
        System.out.println(lt.minPathSumRecMemo(grid));
        System.out.println("Dynamic Programming Bottom up Approach : ");
        System.out.println(lt.minPathSumdp(grid));
    }
}
