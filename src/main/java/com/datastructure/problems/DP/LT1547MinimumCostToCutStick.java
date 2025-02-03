package com.datastructure.problems.DP;

public class LT1547MinimumCostToCutStick {
    //n = 7, cuts = [1,3,4,5]
    int minCostToCutStick(int[] cuts, int stickLength) {
        int[] sl = new int[stickLength];
        for(int i = 0 ; i < stickLength ; i++) {
            sl[i] = i;
        }
        int[][] dp = new int[cuts.length + 1][stickLength + 1];
        for (int i = 0; i < cuts.length + 1; i++) {
            for (int j = 0; j < stickLength + 1; j++) {
                if (j == 0) dp[i][j] = 0;
                if (i == 0) dp[i][j] = 1;
            }
        }

        for (int i = 1; i < cuts.length + 1; i++) {
            for (int j = 1; j < stickLength + 1; j++) {
                if(sl[i-1] <= j)
                    dp[i][j] = Math.min( j + dp[i][j - sl[i-1]], dp[i-1][j] );
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[cuts.length][stickLength];
    }
    public static void main(String[] args) {
        int[] cuts = {1,3,4,5}; int n = 7;
        var lt = new LT1547MinimumCostToCutStick();
        System.out.println(lt.minCostToCutStick(cuts,n));
    }

}
