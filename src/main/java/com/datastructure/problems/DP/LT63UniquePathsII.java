package com.datastructure.problems.DP;

import java.util.Arrays;

public class LT63UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        return calculatePathsWithObstacles(m-1, n-1, obstacleGrid);
    }

    private int calculatePathsWithObstacles(int m, int n,int[][] obstacleGrid) {
        if(m < 0 || n < 0) return 0;
        if(obstacleGrid[m][n] == 1) return 0;
        if(m == 0 && n == 0) return 1;

        int up = calculatePathsWithObstacles(m-1,n,obstacleGrid);
        int left = calculatePathsWithObstacles(m, n-1,obstacleGrid);
        return up+left;
    }


    public int uniquePathsWithObstacles_RecMemo(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] memo = new int[m][n];
        Arrays.stream(memo).forEach(x-> Arrays.fill(x,-1));
        return calculatePathsWithObstaclesRecMemo(m-1, n-1, obstacleGrid,memo);
    }

    private int calculatePathsWithObstaclesRecMemo(int m, int n,int[][] obstacleGrid, int[][] memo) {
        if(m < 0 || n < 0) return 0;

        if(memo[m][n] != -1) return memo[m][n];
        if(obstacleGrid[m][n] == 1) return 0;
        if(m == 0 && n == 0) return 1;
        int up = calculatePathsWithObstaclesRecMemo(m-1,n,obstacleGrid,memo);
        int left = calculatePathsWithObstaclesRecMemo(m, n-1,obstacleGrid,memo);
        return memo[m][n]= up+left;
    }


    public int uniquePathsWithObstacles_dp(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m ;i++) {
            for(int j = 0 ; j < n ; j++){
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else if(i == 0 || j == 0) dp[i][j] = 1;
                else {
                    int up = dp[i-1][j];
                    int left = dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{0,0,0}};
        var lt = new LT63UniquePathsII();
        System.out.println(lt.uniquePathsWithObstacles(mat));
        System.out.println(lt.uniquePathsWithObstacles_RecMemo(mat));
        System.out.println(lt.uniquePathsWithObstacles_dp(mat));
    }
}
