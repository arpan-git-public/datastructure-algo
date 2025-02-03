package com.datastructure.problems.DP;



public class SubsetSum {

    boolean isSubSetPresent(int[] arr, int sum, int n) {
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i = 0 ; i < n+1 ; i++) {
            for(int j = 0 ; j < sum+1; j++) {
                if(j==0)  dp[i][j] = false;
                else if(i == 0)   dp[i][j] = true;
                else if (arr[i-1] <= j ) {
                    //two choices
                    dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }

    public static void main(String[] args) {
        int[] arr = {2,3,7,8,10};
        int sum = 11;
        // if subset is present return true or false.
        var lt = new SubsetSum();
        System.out.println(lt.isSubSetPresent(arr,sum,arr.length));
    }
}
