package org.example.DP;

import java.util.Arrays;

/**
 *
 *
 */

public class EqualSumPartition {

    boolean isEqualSumPartition(int[] arr, int n) {
        int sum = Arrays.stream(arr).sum();
        if(sum % 2 != 0)
            return  false;
        else {
            //base condition
            boolean [][] dp = new boolean[n+1][sum+1];
            for(int i = 0 ; i < n+1; i++) {
                for (int j = 0; j < sum + 1; j++) {
                    if (i == 0) dp[i][j] = false;
                    if (j == 0) dp[i][j] = true;
                }
            }
            //iterate over the conditions
            for(int i = 1 ; i < n+1; i++) {
                for(int j = 1 ; j < sum + 1 ; j++) {
                    if( arr[i-1] <= j){
                        dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[n][sum];
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,5,5,11};
        var lt = new EqualSumPartition();
        System.out.println(lt.isEqualSumPartition(arr,arr.length));
    }


}
