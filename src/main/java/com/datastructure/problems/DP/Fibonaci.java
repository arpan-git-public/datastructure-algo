package com.datastructure.problems.DP;

import java.util.Arrays;
import java.util.List;

public class Fibonaci {
    // 0 1 1 2 3 5 8 13
    public void fibonaci(int n) {
        int firstTerm = 0, secondTerm = 1;
        for(int i = 1 ; i <n ; i++) {
            System.out.print(firstTerm + " ");
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
    }
    //TC: O(2 ^ N)
    // SC: O(N)
    public void fibonaci_rec(int n) {

        for(int i = 0; i < n;i++) {
            System.out.print(fiboRec(i) + " ");
        }
    }

    int fiboRec(int num){
       if(num <= 1) return num;
        return fiboRec(num - 2) + fiboRec(num - 1);
    }

    // Recursion with Memoization:
    // Time complexity : O(N), SC: O(N)
    void fiboRecMemo(int n){
        int[] memo = new int[n];
        for(int i = 0 ; i < n ; i++) {
            System.out.print(fibonaci_rec_memo(i,memo) + " ");
        }
    }

    int fibonaci_rec_memo(int num, int[] memo) {
        //Base condition
        if(memo[num] != 0) return memo[num];

        if(num == 0 || num == 1)
            return num;
        else {
            memo[num] = fibonaci_rec_memo(num-1,memo) + fibonaci_rec_memo(num-2,memo);
            return memo[num];
        }
  }

  int[] fibonacci_dp (int N) {
        int[] dp = new int[N+1];
        dp[0] = 0 ;
         dp[1] = 1;
        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp;
  }

    public static void main(String[] args) {
        var lt = new Fibonaci();
        lt.fibonaci(10);
        System.out.println();
        System.out.println("Recursion approach: ");
        lt.fibonaci_rec(10);
        System.out.println();
        System.out.println("Recursion with Memoization approach: ");
        lt.fiboRecMemo(10);
        System.out.println("Dynamic Programming approach : ");
        Arrays.stream(lt.fibonacci_dp(10)).forEach(x-> System.out.print(x + " "));
    }
}
