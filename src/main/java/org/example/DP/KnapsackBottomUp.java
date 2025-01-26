package org.example.DP;


/**
 * weight[] : 1 3 4 5
 * value[]  : 1 4 5 7
 * W : 7
 */
public class KnapsackBottomUp {

    int knapsack(int[] wt, int[] val, int weight, int n) {
       int[][] t = new int[n+1][weight+1];


        for(int i = 0 ; i < n+1; i ++) {
            for(int j = 0 ; j < weight + 1; j++) {
                if(i == 0 || j ==0)
                    t[i][j] = 0;
                else  if(wt[i-1] <= j) {
                    t[i][j] = Math.max(val[i-1] + t[i-1][j - wt[i-1]], t[i-1][j] );
                } else
                    t[i][j] = t[i-1][j];
            }
        }
        return t[n][weight];
    }

    public static void main(String[] args) {
        int[] wt = {1,3,4,5};
        int[] val = {1,4,5,7};
        int weight = 7;
        var lt = new KnapsackBottomUp();
        int maxProfit = lt.knapsack(wt,val,weight,wt.length);
        System.out.println("Maximum profit : "+ maxProfit);

    }

}
