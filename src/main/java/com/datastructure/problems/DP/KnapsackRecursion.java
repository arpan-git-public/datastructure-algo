package com.datastructure.problems.DP;


import static java.lang.Math.max;

/**
 * weight[] : 1 3 4 5
 * value[]  : 1 4 5 7
 * W : 7
 */
public class KnapsackRecursion {


    private int knapsack(int[] wt, int[] val, int weight, int n) {
        //base condition
        if(n == 0 || weight == 0)
            return 0;

        //choices
        if(wt[n-1] <= weight) {
            //include it or exclude it and move on
            return max(val[n-1] + knapsack(wt,val,weight - wt[n-1],n-1) ,
                    knapsack(wt,val,weight,n-1));
        }else {
            // exclude it and move on
            return knapsack(wt,val,weight,n-1);
        }
    }

    public static void main(String[] args) {
        int[] wt = {1,3,4,5};
        int[] val = {1,4,5,7};
        int weight = 7;
        var lt = new KnapsackRecursion();
        int maxProfit = lt.knapsack(wt,val,weight,wt.length);
        System.out.println("Maximum profit : "+ maxProfit);
    }

}
