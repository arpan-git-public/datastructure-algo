package com.datastructure.problems.DP;


/**
 * weight[] : 1 3 4 5
 * value[]  : 1 4 5 7
 * W : 7
 */
public class KnapsackRecursionMemoization {

    private int knapsack(int[] wt, int[] val, int weight, int n, int[][] t) {
        if(n==0 || weight == 0)
            return 0;
        if(t[n][weight] != -1)
            return t[n][weight];

        if(wt[n-1] <= weight)
            return t[n][weight] = Math.max(val[n-1] + knapsack(wt,val,weight - wt[n-1],n-1,t) , knapsack(wt,val,weight,n-1,t) );
        else
            return  t[n][weight] = knapsack(wt,val,weight,n-1,t);
    }

    public static void main(String[] args) {
        int[] wt = {1,3,4,5};
        int[] val = {1,4,5,7};
        int weight = 7;
        var lt = new KnapsackRecursionMemoization();
        int[][] t = new int[wt.length+1][weight+1];
        for(int i = 0 ; i < wt.length+1; i++) {
            for(int j = 0 ; j < weight + 1; j++) {
                t[i][j] = -1;
            }
        }
        int maxProfit = lt.knapsack(wt,val,weight,wt.length, t);
        System.out.println("Maximum profit : "+ maxProfit);
        for(int i = 0 ; i < wt.length+1; i++) {
            System.out.println();
            for(int j = 0 ; j < weight + 1; j++) {
                System.out.print(t[i][j] + "    ");
            }
        }

    }

}
