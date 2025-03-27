package com.datastructure.problems.Array;

public class LT122BestTimeToBuyandSellStockII {

    public int maxProfit(int[] prices) {
        int max = 0;
        int start = prices[0];

        for(int i = 1 ; i < prices.length; i++) {
            if(start < prices[i])
                max += prices[i] - start;
            start = prices[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,4,6};
        var obj = new LT122BestTimeToBuyandSellStockII();
        System.out.println(obj.maxProfit(arr));
    }
}
