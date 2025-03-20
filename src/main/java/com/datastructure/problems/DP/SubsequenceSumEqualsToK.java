package com.datastructure.problems.DP;

import java.util.Arrays;

public class SubsequenceSumEqualsToK {

    boolean isSubseqSumEqualsToK(int[] arr, int target) {
        //status are index and target.
        return checkSubSeqSumPresent(arr.length-1,target,arr);
    }

    private boolean checkSubSeqSumPresent(int index, int target,int[] arr) {
        if(target == 0) return true;
        if(index == 0) return arr[index] == target;
        boolean exclude = checkSubSeqSumPresent(index-1,target,arr);
        boolean include = false;
        if(target >= arr[index])
            include = checkSubSeqSumPresent(index-1,target-arr[index],arr);
        return  exclude || include;
    }

    boolean isSubseqSumEqualsToKRecMemo(int[] arr, int target) {
        int[][] memo = new int[arr.length][target+1];
        Arrays.stream(memo).forEach(x-> Arrays.fill(x,-1));
        return checkSubSeqSumPresentRecMemo(arr.length-1,arr,target,memo);
    }

    private boolean checkSubSeqSumPresentRecMemo(int index, int[] arr, int target,int[][] memo) {
        if(target == 0) return true;
        if(index == 0) return arr[index] == target;
        if(memo[index][target] != -1) return memo[index][target] == 1;
        boolean exclude = checkSubSeqSumPresent(index-1,target,arr);
        boolean include = false;
        if(target >= arr[index])
            include = checkSubSeqSumPresent(index-1,target-arr[index],arr);
        memo[index][target] = exclude || include? 1:0;
        return memo[index][target]==1 ;
    }

    boolean isSubseqSumEqualsToK_DP(int[] arr, int k) {
       //[index][target]
        boolean[][] dp = new boolean[arr.length][k+1];
        for(int i = 0 ; i < arr.length; i++) {
            dp[i][0] = true;
        }
        dp[0][arr[0]] = true;
        for(int i = 1; i < arr.length ; i++) {
            for(int j = 1; j <= k ; j++) {
                boolean exclude = dp[i-1][j];
                boolean include = false;
                if(j >= arr[i])
                    include = dp[i-1][j-arr[i]];
                dp[i][j] = exclude || include;
            }
        }
        return dp[arr.length-1][k];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int target = 6;
        var lt = new SubsequenceSumEqualsToK();
        System.out.println(lt.isSubseqSumEqualsToK(arr,target));
        System.out.println(lt.isSubseqSumEqualsToKRecMemo(arr,target));
        System.out.println(lt.isSubseqSumEqualsToK_DP(arr,target));
    }


}
