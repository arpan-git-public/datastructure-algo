package com.datastructure.problems.DP;

/**
 *  Given an array of integer pick any two numbers which are non-adjacent and take maximum sum of it.
 *
 *  input = arr : {1,4,9,10}
 *  output= 14
 *
 */
public class MaximumSubsequenceSum {

    int maxSubSequenceSumRec(int index, int[] arr) {
        if(index == 0) return arr[index];
        if(index < 0) return 0;
        int pick = arr[index] + maxSubSequenceSumRec(index-2, arr);
        int notPick = maxSubSequenceSumRec(index - 1, arr);
        return Math.max(pick,notPick);
    }

    int maxSubSequenceSumRecMemo(int index, int[] arr, int[] memo) {
        if(index ==0) return arr[index];
        if(index < 0) return 0;
        if(memo[index] != 0) return memo[index];
        int pick = arr[index] + maxSubSequenceSumRecMemo(index-2,arr,memo);
        int notPick = maxSubSequenceSumRecMemo(index-1,arr,memo);
        return Math.max(pick,notPick);
    }

    int maxSubSequenceSumTabulation( int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for(int i = 1; i < arr.length ; i++) {
            int  take = arr[i];
              if(i > 1) take += dp[i-2];

            int noTake = dp[i-1];
            dp[i] = Math.max(take,noTake);
        }
        return dp[arr.length-1];
    }

    int maxSubSequenceSumSpaceOptimization(int[] arr) {
        int prev = 0 , secondPrev = 0;
        int maxElement = arr[0];
        for(int i = 1; i < arr.length ; i++) {
            int  take = arr[i];
            if(i > 1) {
                take += secondPrev;
            }
            maxElement = Math.max(maxElement,Math.max(take,prev));
            secondPrev = prev;
            prev=maxElement;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,9,10};
        var lt = new MaximumSubsequenceSum();
        System.out.println("Recursion Approach : ");
        System.out.println(lt.maxSubSequenceSumRec(arr.length-1,arr));
        System.out.println("Recursion with Memoization Approach : ");
        int[] memo = new int[arr.length];
        System.out.println(lt.maxSubSequenceSumRecMemo(arr.length-1,arr,memo));
        System.out.println("Dynamic Programming Approach : ");
        System.out.println(lt.maxSubSequenceSumTabulation(arr));

        System.out.println("Space Optimized solution");
        System.out.println(lt.maxSubSequenceSumSpaceOptimization(arr));
    }
}
