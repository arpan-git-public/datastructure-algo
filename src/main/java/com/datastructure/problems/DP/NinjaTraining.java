package com.datastructure.problems.DP;

import java.util.Arrays;

public class NinjaTraining {

    int maxPointsFromTraining(int[][] arr, int index, int lastTask) {
        // task: 0 -> 2 (arr[0].length) + extra for no task on starting (n-1)th day
        // days: 0 -> n-1 (arr.length -1)

        //Base condition
        if(index == 0) {
            int maxPoint = 0;
            for(int i = 0; i< 3;i++) {
                if(i != lastTask) {
                    maxPoint = Math.max(maxPoint,arr[0][i]);
                }
            }
            return maxPoint;
        }
        int maxPoint = 0;
        for(int i = 0 ; i < 3; i++) {
            int point = 0;
            if(i != lastTask) {
                point = arr[index][i] + maxPointsFromTraining(arr, index - 1,i);
                maxPoint = Math.max(maxPoint,point);
            }
        }
        return maxPoint;
    }

    //Recursion + memoization
    // need matrix of days * Tasks ((0,1,2,3)) which is n * 4
    int maxPointsFromTrainingRecMemo(int[][] arr, int index, int lastTask, int[][] memo) {
        // task: 0 -> 2 (arr[0].length) + extra for no task on starting (n-1)th day
        // days: 0 -> n-1 (arr.length -1)

        //Base condition
        if(memo[index][lastTask] != -1)
            return memo[index][lastTask];

        if(index == 0) {
            int maxPoint = 0;
            for(int i = 0; i< 3;i++) {
                if(i != lastTask) {
                    maxPoint = Math.max(maxPoint,arr[0][i]);
                }
            }
            return maxPoint;
        }


        int maxPoint = 0;
        for(int i = 0 ; i < 3; i++) {
            int point;
            if(i != lastTask) {
                point = arr[index][i] + maxPointsFromTraining(arr, index - 1,i);
                maxPoint = Math.max(maxPoint,point);
                memo[index][i] = maxPoint;
            }
        }
        return maxPoint;
    }

    int maxPointsFromTrainingDP(int[][] arr) {
        // task: 0 -> 2 (arr[0].length) + extra for no task on starting (n-1)th day
        // days: 0 -> n-1 (arr.length -1)

        //Base condition
        int[][] dp = new int[arr.length][4];
        dp[0][0] = Math.max(arr[0][1],arr[0][2]);
        dp[0][1] = Math.max(arr[0][0],arr[0][2]);
        dp[0][2] = Math.max(arr[0][0],arr[0][1]);
        dp[0][3] = Math.max(arr[0][0],Math.max(arr[0][1],arr[0][2]));

        for(int i = 1 ; i < arr.length; i++) {
            for(int j = 0 ; j < 4; j++) {
                int point = 0;
                for(int k = 0 ; k < 3; k++) {
                    point = Math.max(point,arr[i][k]);
                }
                dp[i][j] = point + dp[i-1][j];
            }
        }
        return dp[arr.length-1][3];
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,5},{3,1,1},{3,3,3}}; // 5+3+3 = 11 expected
        int lastTask = 3; // New Introduction to track No task performed yet.
        System.out.println("Recursion Approach : ");
        var lt = new NinjaTraining();
        System.out.println(lt.maxPointsFromTraining(arr,arr.length-1,lastTask));

        System.out.println("Recursion with Memoization Approach : ");
        int[][] memo = new int[arr.length][4];
        for(int i = 0 ; i < memo.length; i++) {
            for(int j = 0; j < memo[i].length;j++) {
                memo[i][j] = -1;
            }
        }
        System.out.println(lt.maxPointsFromTrainingRecMemo(arr,arr.length-1,lastTask,memo));
        System.out.println("DP tabulation Approach : ");
        System.out.println(lt.maxPointsFromTrainingDP(arr));
    }
}
