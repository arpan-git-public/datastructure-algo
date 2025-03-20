package com.datastructure.problems.DP;

import java.util.Arrays;

/**
 * Similar Question:
 * You are the teacher of a class and you have totalStudents students in the class. You are asked to choose chooseLimit students from your class for a competition. All your students are equally competent. Find the number of ways you can choose chooseLimit students from a class of totalStudents students.
 * Note : Number of ways of choosing 0 students from totalStudents is 1.
 *
 *
 * Input: totalStudents = 3, chooseLimit = 2
 * Output: 3
 * Explanation: Ways to choose 2 students from 3 is: {1,2}, {1,3}, {2,3}.
 *
 *
 * Company Tags: D.E.Shaw
 *
 *
 * Constraints:
 * 1 <= totalStudents <= 200
 * 0 <= chooseLimit <= totalStudents
 *
 *
 * Approach 1 : Using Top Down DP (Recursion To Memoization)
 */

public class CountNumOfSubSetsWithGivenSum {

    int countNumOfSubSetOfSumK(int[] arr, int sum) {
        return countPairsOfSumRec(arr,arr.length-1,sum);
    }

    int countPairsOfSumRec(int[] arr, int index, int sum) {
        if(sum == 0) return 1;
        if(index == 0) return arr[index] == sum ? 1: 0;
         //exclude
        int exclude = countPairsOfSumRec(arr,index-1,sum);
        //include
        int include = 0;
        if(sum >= arr[index])
            include = countPairsOfSumRec(arr,index-1,sum - arr[index]);
        return exclude + include;
    }

    int countNumOfSubSetOfSumKRecMemo(int[] arr, int sum) {
        int[][] memo = new int[arr.length][sum+1];
        Arrays.stream(memo).forEach(x-> Arrays.fill(x,-1));
        return countPairsOfSumRecMemo(arr,arr.length-1,sum,memo);
    }


    int countPairsOfSumRecMemo(int[] arr, int index, int sum,int[][] memo) {
        if(sum == 0) return 1;
        if(index == 0) return arr[index] == sum ? 1: 0;
        if(memo[index][sum] != -1) return memo[index][sum];
        //exclude
        int exclude = countPairsOfSumRecMemo(arr,index-1,sum,memo);
        //include
        int include = 0;
        if(sum >= arr[index])
            include = countPairsOfSumRecMemo(arr,index-1,sum - arr[index],memo);
        return memo[index][sum] = exclude + include;
    }

    int countNumOfSubSetOfSumK_DP(int[] arr, int sum) {
        int[][] dp = new int[arr.length][sum+1];
        for(int i = 0 ; i < arr.length ; i++) {
            dp[i][0] = 1;
        }
        if(arr[0] <= sum) dp[0][arr[0]] = 1;

        for(int i = 1 ; i < arr.length; i++) {
            for(int target = 1; target < sum+1; target++) {
                int exclude = dp[i-1][target];
                int include = 0;
                if(arr[i] <= target)
                    include = dp[i-1][target-arr[i]];
                dp[i][target] = exclude + include;
            }
        }
        return dp[arr.length-1][sum];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3}; int target = 3;
        var lt = new CountNumOfSubSetsWithGivenSum();
        System.out.println(lt.countNumOfSubSetOfSumK(arr,target));
        System.out.println(lt.countNumOfSubSetOfSumKRecMemo(arr,target));
        System.out.println(lt.countNumOfSubSetOfSumK_DP(arr,target));
    }
}
