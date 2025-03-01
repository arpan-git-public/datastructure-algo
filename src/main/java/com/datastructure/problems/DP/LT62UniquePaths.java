package com.datastructure.problems.DP;

import java.util.Arrays;

/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 *
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 *
 * Example 1:
 *
 * Input: m = 3, n = 7
 * Output: 28
 * Example 2:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 *
 *
 * Constraints:
 *
 * 1 <= m, n <= 100
 */
public class LT62UniquePaths {
    //Recursion
    public int uniquePaths(int m, int n) {
        return countPathRec(m-1,n-1);
    }
    int countPathRec(int i, int j) {
        if(i == 0 && j ==0) return 1;
        if(i < 0 || j < 0) return 0;

        int up = countPathRec(i-1,j);
        int left = countPathRec(i, j-1);
        return up+left;
    }

    //Recursion with Memoization
    public int uniquePaths_memo(int m, int n) {
        int[][] memo = new int[m][n];
        Arrays.stream(memo).forEach(x-> Arrays.fill(x,-1));
        return countPathRecMemo(m-1,n-1,memo);
    }
    int countPathRecMemo(int i, int j,int[][] memo) {
        if(i == 0 && j ==0) return 1;
        if(i < 0 || j < 0) return 0;
        if(memo[i][j] != -1) return memo[i][j];

        int up = countPathRecMemo(i-1,j,memo);
        int left = countPathRecMemo(i, j-1,memo);
        return memo[i][j] = up+left;
    }

    //Dynamic Programming
    public int uniquePaths_dp(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i = 0 ; i < m; i++) {
            for(int j = 0 ; j < n; j++) {
                if(i== 0 || j ==0) dp[i][j] = 1;
                else  dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }



    public static void main(String[] args) {
        var lt = new LT62UniquePaths();
        System.out.println(lt.uniquePaths(3,7));
        System.out.println(lt.uniquePaths_memo(3,7));
        System.out.println(lt.uniquePaths_dp(3,7));
    }
}
